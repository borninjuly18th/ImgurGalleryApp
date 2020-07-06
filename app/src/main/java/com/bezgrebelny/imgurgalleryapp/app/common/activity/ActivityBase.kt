package com.bezgrebelny.imgurgalleryapp.app.common.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

abstract class ActivityBase : AppCompatActivity() {

    abstract val di: Module
    abstract val vm: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(di)
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(di)
    }
}