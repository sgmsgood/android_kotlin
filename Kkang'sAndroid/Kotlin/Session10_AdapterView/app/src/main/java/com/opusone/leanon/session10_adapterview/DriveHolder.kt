package com.opusone.leanon.session10_adapterview

import android.view.View
import kotlinx.android.synthetic.main.custom_item.view.*

class DriveHolder(view: View?) {
    val typeImageView = view?.custom_item_type_image
    val titleView = view?.custom_item_title
    val dateView = view?.custom_item_date
    val menuImageView = view?.custom_item_menu
}