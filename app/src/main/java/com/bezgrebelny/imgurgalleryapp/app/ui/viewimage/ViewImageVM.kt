package com.bezgrebelny.imgurgalleryapp.app.ui.viewimage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bezgrebelny.imgurgalleryapp.app.common.activity.EventViewModel
import com.bezgrebelny.imgurgalleryapp.app.common.extentions.isLoading
import com.bezgrebelny.imgurgalleryapp.core.common.extentions.process
import com.bezgrebelny.imgurgalleryapp.core.model.GalleryCommentModel
import com.bezgrebelny.imgurgalleryapp.core.repository.GalleryRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ViewImageVM(
    private val content: ViewImageContent,
    private val galleryRepository: GalleryRepository
) : EventViewModel<Event>() {

    val data = MutableLiveData<Any>()
    val commentList = MutableLiveData<List<GalleryCommentModel>>()

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            isLoading({
                setEvent(Event.Loading(it))
            }, {
                val galleryJob = async {
                    if (content.isAlbum) galleryRepository.getGalleryAlbum(content.id)
                    else galleryRepository.getGalleryImage(content.id)
                }
                val commentsJob = async { galleryRepository.getGalleryComments(content.id) }

                galleryJob.await().process({
                    data.postValue(it)
                }, {
                    setEvent(Event.Error)
                    return@launch
                })
                commentsJob.await().process({
                    commentList.postValue(it)
                }, {
                    setEvent(Event.Error)
                    return@launch
                })
            })
        }
    }
}