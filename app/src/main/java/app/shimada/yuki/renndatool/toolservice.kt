package app.shimada.yuki.renndatool

import android.R
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.IBinder
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.WindowManager


class toolService() : Service(), Parcelable {
    var view: View? = null
    var wm: WindowManager? = null

    constructor(parcel: Parcel) : this() {

    }

    override fun onStart(intent: Intent, startId: Int) {
        super.onStart(intent, startId)

        // Viewからインフレータを作成する
        val layoutInflater = LayoutInflater.from(this)

        // 重ね合わせするViewの設定を行う
        val params = WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                PixelFormat.TRANSLUCENT)

        // WindowManagerを取得する
        wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager

        // レイアウトファイルから重ね合わせするViewを作成する
        view = layoutInflater.inflate(R.layout.overlay_screen, nullParent);


        // Viewを画面上に重ね合わせする
        wm!!.addView(view, params)
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()

        // サービスが破棄されるときには重ね合わせしていたViewを削除する
        wm!!.removeView(view)
    }

    override fun onBind(intent: Intent): IBinder? {
        // TODO Auto-generated method stub
        return null
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<toolService> {
        override fun createFromParcel(parcel: Parcel): toolService {
            return toolService(parcel)
        }

        override fun newArray(size: Int): Array<toolService?> {
            return arrayOfNulls(size)
        }
    }
}
