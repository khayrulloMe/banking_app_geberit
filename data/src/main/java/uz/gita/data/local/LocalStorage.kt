package uz.gita.data.local

import android.content.Context
import uz.gita.data.utils.SharedPreference
import javax.inject.Inject

/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/

class LocalStorage(context: Context) :
    SharedPreference(context) {
    var accessToken: String by Strings()
    var refreshToken: String by Strings()
    var theme: String by Strings("LITE")

}