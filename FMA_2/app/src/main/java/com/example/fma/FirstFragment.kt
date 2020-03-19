package com.example.fma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    //FirstFragmentのviewを生成
    override fun onCreateView(
        //LayoutInflaterとコンテナの作成
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //fragmentのレイアウトをxmlから生成
        return inflater.inflate(R.layout.fragment_first, container, false)
    }
    //onCreateViewで生成したviewを初期化
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            //randomボタンが押された際、navigateメソッドの引数に指定されたIDのビューを取得し、そこに移動する
        view.findViewById<Button>(R.id.random_button).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        //toastボタンが押された際、画面下部に短時間Hello Toast!というトーストを表示する
        view.findViewById<Button>(R.id.toast_button).setOnClickListener{
            val myToast = Toast.makeText(context,"Hello Toast!", Toast.LENGTH_SHORT)
            myToast.show()
        }
        //countボタンが押された際、countMeメソッドを使用し、ビューの数字を増やす
        view.findViewById<Button>(R.id.count_button).setOnClickListener {
            countMe(view)
        }
    }
    private fun countMe(view: View) {
        //text　view_firstからtext view取得
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        //text viewの値取得
        val countString = showCountTextView.text.toString()
        //値を取得し数値に変換
        var count = countString.toInt()
        count++

        //text viewに新たな値を表示
        showCountTextView.text = count.toString()
    }
}
