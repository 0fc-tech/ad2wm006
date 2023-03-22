package com.example.mod10recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mod10recyclerview.databinding.TemplateMinistreItemBinding
import com.squareup.picasso.Picasso

class MinistreAdapter(val alMinistres : List<Ministre>,val clickMinistre : (ministre:Ministre) -> Unit)
    : RecyclerView.Adapter<MinistreAdapter.MinistreVH>()  {
    //lateinit var ministreClickListener : OnMinistreClick
    //Permet à notre item de liste d'être recycler
    class MinistreVH(val binding : TemplateMinistreItemBinding) : ViewHolder(binding.root)

    //Va crééer le ViewHolder => L'élément qui sera recyclé
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MinistreVH {
        val binding = TemplateMinistreItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return MinistreVH(binding)
    }
    //Associe un ministre à un ViewHolder
    override fun onBindViewHolder(holder: MinistreVH, position: Int) {
        holder.binding.ministre = alMinistres[position]
        Picasso.get().load(alMinistres[position].photoUrl).into(holder.binding.imageViewProfil)
        holder.itemView.setOnClickListener {
            clickMinistre(alMinistres[position])
        }
    }
    //Récupère le nomber d'items à affichers
    override fun getItemCount(): Int  = alMinistres.size
    //fun setOnMinistreClickListener(ministreClickListener : OnMinistreClick){
    //    this.ministreClickListener = ministreClickListener
    //}
}
//fun interface OnMinistreClick{
//    fun onMinistreClick(ministre:Ministre) : Unit
//}