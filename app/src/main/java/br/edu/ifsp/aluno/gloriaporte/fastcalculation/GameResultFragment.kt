package br.edu.ifsp.aluno.gloriaporte.fastcalculation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.edu.ifsp.aluno.gloriaporte.fastcalculation.Extras.EMPTY_STRING
import br.edu.ifsp.aluno.gloriaporte.fastcalculation.Extras.EXTRA_SCORE
import br.edu.ifsp.aluno.gloriaporte.fastcalculation.databinding.FragmentGameResultBinding

class GameResultFragment : Fragment() {
    private lateinit var binding: FragmentGameResultBinding
    private lateinit var score: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            score = it.getString(EXTRA_SCORE) ?: EMPTY_STRING
        }
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameResultBinding.inflate(inflater, container, false)
        score.also {
            binding.textScore.text = it
        }
        binding.buttonRestartGame.setOnClickListener {
            (context as OnPlayGame).onPlayGame()
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(score: String) =
            GameResultFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_SCORE, score)
                }
            }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.restartGameMi).isVisible = false
    }

}