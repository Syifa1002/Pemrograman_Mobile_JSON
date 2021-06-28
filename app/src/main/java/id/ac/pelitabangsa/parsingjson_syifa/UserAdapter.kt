package id.ac.pelitabangsa.parsingjson_syifa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import id.ac.pelitabangsa.parsingjson_syifa.model.DataItem

class UserAdapter(private val users: Unit) :
        RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ListViewHolder {
        val view: View
                LayoutInflater.from(parent.context).inflate(R.layout.item_list_user, parent, false)
        return ListViewHolder(
                view
        )
    }

    fun adduser(newUser: DataItem) {
        users.add(newUser)
        notifyItemInserted(users.lostIndex)
    }

    fun clear() {
        users.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserAdapter.ListViewHolder, position: Int) {
        val user = users[position]

        Glide.with(holder.itemView.context)
                .load(user.avatar)
                .apply(RequestOptions().override(80, 80).placeholder(R.drawable.icon_avatar))
                .transform(CircleCrop())
                .into(holder.ivAvatar)

        holder.tvUserName.text = "${user.firstName}${user.lastName}"
        holder.tvEmail.text = user.email
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvUserName: TextView = itemView.findViewById(R.id.ItemName)
        var tvEmail: TextView = itemView.findViewById(R.id.ItemEmail)
        var ivAvatar: ImageView = itemView.findViewById(R.id.itemAvatar)
    }

}