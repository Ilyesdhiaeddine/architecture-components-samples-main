/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package paging.android.example.com.pagingsample

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeoutException

/**
 * Simply sanity test to ensure that activity launches without any issues and shows some data.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    @Throws(InterruptedException::class, TimeoutException::class)
    fun showSomeResults() {
        val intent = Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val scenario = ActivityScenario.launch<MainActivity>(intent)

        scenario.onActivity { activity ->
            val recyclerView: RecyclerView = activity.binding.cheeseList
            MatcherAssert.assertThat(recyclerView.adapter, CoreMatchers.notNullValue())
            MatcherAssert.assertThat(recyclerView.adapter!!.itemCount > 0, CoreMatchers.`is`(true))
        }
    }
}