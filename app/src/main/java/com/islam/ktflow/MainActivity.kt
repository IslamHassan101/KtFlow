package com.islam.ktflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.islam.ktflow.ui.theme.KtFlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtFlowTheme {

                val viewModel = viewModels<MainViewModel>()

                val time = viewModel.value.countDownFlow.collectAsState(initial = 10)

                Box(modifier = Modifier.fillMaxSize()) {
                    Text(text = time.value.toString(), modifier = Modifier.align(Alignment.Center))
                }

            }
        }
    }
}
