package app.shimada.yuki.renndatool

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun isOverlayGranted() =
                Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                        Settings.canDrawOverlays(this)

        fun requestOverlayPermission() {
            if (isOverlayGranted()) return
            val intent = Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:$packageName")
            )
        }

    }


            startbutton.setOnClickListener {
                startService(toolService)
            }
        }

        private fun startService(toolService: toolService.CREATOR) {

        }
    }

