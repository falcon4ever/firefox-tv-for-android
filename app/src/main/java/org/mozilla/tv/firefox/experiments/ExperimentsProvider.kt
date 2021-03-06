/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.tv.firefox.experiments

import android.content.Context
import io.sentry.Sentry
import mozilla.components.service.fretboard.ExperimentDescriptor
import mozilla.components.service.fretboard.Fretboard
import org.mozilla.tv.firefox.R

/**
 * [ExperimentsProvider] checks for experiment branch from [Fretboard] to provide its respective content.
 * See [getAAExitButtonExperiment] for example
 *
 * Note: Consider implementing fallback options (log in Sentry using [ExperimentIllegalStateException]
 * since fretboard doesn't necessarily load the latest changes from Kinto backend. See
 * [FretboardProvider.updateExperiments] and [FretboardProvider.loadExperiments] for more details
 */
class ExperimentsProvider(private val fretboard: Fretboard, private val context: Context) {

    fun getAAExitButtonExperiment(expConfig: ExperimentConfig): String {
        val expDescriptor = checkBranchVariants(expConfig)
        return if (expDescriptor != null) {
            when {
                (expDescriptor.name.endsWith(ExperimentSuffix.A.value)) ->
                    context.resources.getString(R.string.exit_firefox_a11y,
                        context.resources.getString(R.string.firefox_tv_brand_name_short))
                (expDescriptor.name.endsWith(ExperimentSuffix.B.value)) ->
                    context.resources.getString(R.string.exit_firefox_a11y,
                        context.resources.getString(R.string.firefox_tv_brand_name_short))
                // Fallback: AA testing should be 50/50 so technically should never get to else.
                else -> {
                    Sentry.capture(ExperimentIllegalStateException("AATestIllegalBranchName"))
                    context.resources.getString(R.string.exit_firefox_a11y,
                        context.resources.getString(R.string.firefox_tv_brand_name_short))
                }
            }
        } else {
            // The user is currently not part of the experiment
            Sentry.capture(NotInExperimentException("AAExperiment"))
            context.resources.getString(R.string.exit_firefox_a11y,
                context.resources.getString(R.string.firefox_tv_brand_name_short))
        }
    }

    fun shouldShowHintBar(): Boolean {
// TODO before enabling this code:
// - Get UX approval for hint bar UI
// - Get localizations for all hint bar strings (hint_press_menu_to_close_overlay,
//   hint_press_menu_to_open_overlay, hardware_button_a11y_menu, hardware_button_a11y_back)
// TODO after enabling this code:
// - Set up Fretboard for 'HintBar-2011' experiment so this actually works
        return false
//        val expDescriptor = checkBranchVariants(ExperimentConfig.HINT_BAR_TEST)
//        return when {
//            // The user is currently not part of the experiment
//            expDescriptor == null -> false
//            expDescriptor.name.endsWith(ExperimentSuffix.A.value) -> true
//            expDescriptor.name.endsWith(ExperimentSuffix.B.value) -> false
//            else -> {
//                Sentry.capture(ExperimentIllegalStateException("Hint Bar Illegal Branch Name"))
//                false
//            }
//        }
    }

    /**
     * Check if [ExperimentConfig] + [ExperimentSuffix] is in the experiment and return its
     * corresponding [ExperimentDescriptor].
     *
     * Return null otherwise
     */
    private fun checkBranchVariants(expConfig: ExperimentConfig): ExperimentDescriptor? {
        for (suffix in ExperimentSuffix.values()) {
            val expDescriptor = ExperimentDescriptor(expConfig.value + ":" + suffix.name)
            if (fretboard.isInExperiment(context, expDescriptor)) {
                // Correct experiment variant is found
                return expDescriptor
            }
        }

        // No matching experiment, so return null
        return null
    }
}
