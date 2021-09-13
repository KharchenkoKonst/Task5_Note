package com.example.task5_note.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.task5_note.R
import com.example.task5_note.databinding.ActivityMainBinding

/*
Приоритетно (выполнено):

1. Выполнить локализацию приложения на английский язык (регионе не важен).
2. Перевести приложение с MVP на MVVM.
3. Реализовать привязку данных одним способом на выбор (исп. Data Binding).
4. Написать модульные тесты на одну ViewModel (NoteContentViewModel).

Опционально (не выполнено):

1. Реализовать поддержку доступности.
2. Реализовать работу с голосовыми заметками (добавление из файла или Content Provider + проигрывание).
 */

/*
MainActivity - контейнер для фрагментов с использованием navigation component.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val navController by lazy {
        Navigation.findNavController(this, binding.navHost.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
    }
}