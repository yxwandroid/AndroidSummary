package com.wilson.serviceview

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.fastjson.JSON
import com.orhanobut.logger.Logger
import java.util.*
import java.util.function.Consumer
import kotlin.collections.ArrayList

class Main3Activity : AppCompatActivity() {
    private var mqickRepluEntity: QuickReplyEntity? = null;
    private var show: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        show = findViewById<TextView>(R.id.show)



        initQuickReplyData();
    }


    private fun initQuickReplyData() {
        Thread {
            val json = LocalJsonResolutionUtils.getJson(this, "file.json")
            Logger.i("QuickReplySetting： initQuickReplyData  %s, ", json)
            var quickRepluEntity = if (json != null) {
                JSON.parseObject(json, QuickReplyEntity::class.java)
            } else {
                null
            }

            runOnUiThread {
                mqickRepluEntity = quickRepluEntity;
                show?.text = (quickRepluEntity?.lastUpdateDate).toString()
            }
            Logger.i("QuickReplySetting： initQuickReplyData  %s, ", quickRepluEntity.toString())
        }.start()

    }





}
