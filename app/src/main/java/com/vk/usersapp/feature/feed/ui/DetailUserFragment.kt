package com.vk.usersapp.feature.feed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.vk.usersapp.R

class DetailUserFragment : Fragment() {

    private val args: DetailUserFragmentArgs by navArgs()
    var photoView: ImageView? = null
    var titleView: TextView? = null
    var subTitleView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext())
            .inflate(R.layout.fr_detail_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        photoView = view.findViewById(R.id.photoDetail)
        titleView = view.findViewById(R.id.titleDetail)
        subTitleView = view.findViewById(R.id.subtitleDetail)
        val user = args.user

        Glide.with(photoView!!).load(user.image).into(photoView!!)
        titleView?.text = "${user.firstName} ${user.lastName}"
        subTitleView?.text = user.university
    }
}