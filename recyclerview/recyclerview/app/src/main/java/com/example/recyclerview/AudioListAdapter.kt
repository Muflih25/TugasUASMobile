import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R

class AudioListAdapter(private val audioList: List<Int>) : RecyclerView.Adapter<AudioListAdapter.ViewHolder>() {

    private var mediaPlayer: MediaPlayer? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val titleTextView: TextView = itemView.findViewById(R.id.textTitle)
        private val btnPlay: ImageButton = itemView.findViewById(R.id.btnPlay)

        init {
            itemView.setOnClickListener(this)
            btnPlay.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            val audioResourceId = audioList[position]

            // Inisialisasi atau putar audio menggunakan MediaPlayer
            when (v?.id) {
                R.id.btnPlay -> {
                    mediaPlayer?.release()
                    mediaPlayer = MediaPlayer.create(itemView.context, audioResourceId)
                    mediaPlayer?.start()
                }
                else -> {
                    // Handle item click if needed
                }
            }
        }

        fun bind(audioResourceId: Int) {
            // Atur teks judul atau informasi lainnya di sini jika diperlukan
            titleTextView.text = "Audio ${adapterPosition + 1}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_audio, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val audioResourceId = audioList[position]
        holder.bind(audioResourceId)
    }

    override fun getItemCount(): Int {
        return audioList.size
    }
}
