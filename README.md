# AppToAppTestApp
AppToApp Test Application


# AndroidManifest.xml

```
<intent-filter>
  <action android:name="android.intent.action.VIEW" />
  <action android:name="android.intent.action.MAIN" />
  <category android:name="android.intent.category.DEFAULT" />
  <category android:name="android.intent.category.BROWSABLE" />
  <category android:name="android.intent.category.LAUNCHER" />

  <data
    android:host="test_host"
    android:scheme="test_scheme"/>
</intent-filter>

```

#Data Parameter

```
        val intent = getIntent()
        if(intent.action.equals(Intent.ACTION_VIEW)){
            val uri = intent.data
            val temp = uri?.getQueryParameter("test_data")
            if(temp != null){
                runOnUiThread {
                    txt_response.text = temp
                }
            }
        }
```
