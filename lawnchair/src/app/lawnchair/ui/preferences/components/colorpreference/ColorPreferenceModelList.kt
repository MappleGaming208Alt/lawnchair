package app.lawnchair.ui.preferences.components.colorpreference

import android.content.Context
import app.lawnchair.preferences2.PreferenceManager2
import app.lawnchair.util.MainThreadInitializedObject
import com.android.launcher3.R

class ColorPreferenceModelList(context: Context) {
    private val models = mutableMapOf<String, ColorPreferenceModel>()

    init {
        val prefs = PreferenceManager2.getInstance(context)
        registerModel(
            ColorPreferenceModel(
                prefObject = prefs.accentColor,
                labelRes = R.string.accent_color,
                dynamicEntries = dynamicColors,
            ),
        )
        registerModel(
            ColorPreferenceModel(
                prefObject = prefs.strokeColorStyle,
                labelRes = R.string.qsb_hotseat_stroke_color,
                dynamicEntries = dynamicColors,
            ),
        )
        registerModel(
            ColorPreferenceModel(
                prefObject = prefs.notificationDotColor,
                labelRes = R.string.notification_dots_color,
                dynamicEntries = dynamicColorsWithDefault,
            ),
        )
        registerModel(
            ColorPreferenceModel(
                prefObject = prefs.notificationDotTextColor,
                labelRes = R.string.notification_dots_text_color,
                dynamicEntries = dynamicColorsWithDefault,
            ),
        )
        registerModel(
            ColorPreferenceModel(
                prefObject = prefs.folderColor,
                labelRes = R.string.folder_preview_bg_color_label,
                dynamicEntries = dynamicColorsWithDefault,
            ),
        )
    }

    operator fun get(key: String): ColorPreferenceModel = models.getValue(key)

    private fun registerModel(model: ColorPreferenceModel) {
        models[model.prefObject.key.name] = model
    }

    companion object {
        val INSTANCE = MainThreadInitializedObject(::ColorPreferenceModelList)
    }
}
