package com.example.superhero

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide


//import com.example.superhero.SuperheroesFragment.OnListFragmentInteractionListener

import kotlinx.android.synthetic.main.fragment_superheroes.view.*


class MySuperheroesRecyclerViewAdapter(
    private val mContext: MainActivity,
    private val mValues: ArrayList<HashMap<String, Any>>

) : RecyclerView.Adapter<MySuperheroesRecyclerViewAdapter.ViewHolder>() {

//    private val mOnClickListener: View.OnClickListener
//
//    init {
//        mOnClickListener = View.OnClickListener { v ->
//            val item = v.tag as DummyItem
//            // Notify the active callbacks interface (the activity, if the fragment is attached to
//            // one) that an item has been selected.
//            mListener?.onListFragmentInteraction(item)
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_superheroes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        holder.mContentView.text = item["name"].toString()
        holder.mPower.text = item["power"].toString()
        holder.mGender.text = item["gender"].toString()
        Glide.with(mContext).load(item["image"]).into(holder.mImage)


        holder.mView.setOnClickListener {
            Toast.makeText(mContext, item["name"].toString(), Toast.LENGTH_LONG).show()
//            Log.e("Test", item["name"].toString() )

//           Toast.makeText(mContext, item["name"].toString(), Toast.LENGTH_LONG).show()


        }
    }


    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mContentView: TextView = mView.name
        val mGender : TextView = mView.gender
        val mPower : TextView = mView.power
        val mImage: ImageView = mView.picture




//        override fun toString(): String {
//            return super.toString() + " '" + mContentView.text + "'"
//        }
    }
}

