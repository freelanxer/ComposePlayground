package com.freelanxer.composeplayground.compose.settings

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.freelanxer.composeplayground.TopBarView
import com.freelanxer.composeplayground.model.SettingsGroup

@Composable
fun SettingsScreen(
    onBackClicked: () -> Unit
) {
    Surface {
        Column(modifier = Modifier) {
            TopBarView(
                title = "Settings",
                onBackClicked = onBackClicked,
            )
            ContentView()
        }
    }
}

/**
 * 內容
 */
@Composable
fun ContentView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        SwitcherSettings(settingsGroup = SettingsGroup("Display"))
    }
}

@Composable
fun SwitcherSettings(settingsGroup: SettingsGroup) {
    Card(
        modifier = Modifier
            .wrapContentHeight(Alignment.Top)
            .fillMaxWidth()
            .padding(
                start = 10.dp,
                end = 10.dp,
                top = 20.dp,
            )
    ) {
        Column(
            modifier = Modifier.padding(vertical = 15.dp)
        ) {
            Text(
                text = settingsGroup.category,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        bottom = 15.dp
                    )
            )
            for (settingName in settingsGroup.settingsList) {
                SwitcherItem(settingName)
            }
        }
    }
}

@Composable
fun SwitcherItem(settingName: String) {
    val context = LocalContext.current;
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {
        var checked by remember { mutableStateOf(true) }
        Text(
            text = settingName,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(top = 10.dp)
        )
        Switch(
            enabled = true,
            checked = checked,
            onCheckedChange = {
                checked = it
                Toast.makeText(context,
                    "$settingName ${if (it) "On" else "Off"}",
                    Toast.LENGTH_SHORT)
                    .show()
            },
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSettingsScreen() {
    SettingsScreen({})
}