package app.shimada.yuki.renndatool

private fun requestOverlayPermission() {
    if (isOverlayGranted()) return
    val intent = Intent(
            Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
            Uri.parse("package:$packageName")
    )