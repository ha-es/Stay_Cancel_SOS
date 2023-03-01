package com.example.stay_cancel_sos

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list.*


class ListActivity : Activity() {

    val contatsList : List<Contacts> = listOf(
        Contacts("부산갈매기", "부산 송정 폴마레 풀빌라 펜션"),
        Contacts("한옥love", "강릉 독채 한옥 펜션"),
        Contacts("jejujeju", "서귀포 애견동반 돔그라미"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val adapter = ContactsListAdapter(contatsList)
        mRecyclerView.adapter = adapter
    }
}