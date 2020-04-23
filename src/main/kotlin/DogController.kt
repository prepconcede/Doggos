import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import tornadofx.Controller
import java.net.URL

data class Response(
    @SerializedName("message")
    var message: List<String>? = null,
    @SerializedName("status")
    var status: String? = null
)

class DogController : Controller() {
    fun getData(num: Int): List<String> {
        val json = URL("https://dog.ceo/api/breeds/image/random/$num").readText()
        val parsedJson = Gson().fromJson(json, Response::class.java)
        val msgs = parsedJson?.message ?: emptyList()
        return msgs
    }
}