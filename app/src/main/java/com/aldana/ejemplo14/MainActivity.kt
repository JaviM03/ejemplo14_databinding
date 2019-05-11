package com.aldana.ejemplo14

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.aldana.ejemplo14.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var score=Score("0","0")
    lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)
        score.score_A = scoreViewModel.scoreTeamA.toString()
        score.score_B = scoreViewModel.scoreTeamB.toString()
        binding.team = score

        bt_team_a_free_throw.setOnClickListener {
            scoreViewModel.scoreTeamA ++
            score.score_A = scoreViewModel.scoreTeamA.toString()
            binding.team = score
        }
        bt_team_b_free_throw.setOnClickListener {
            scoreViewModel.scoreTeamB ++
            score.score_B = scoreViewModel.scoreTeamA.toString()
            binding.team = score
        }

        bt_team_a_2_p.setOnClickListener {
            scoreViewModel.scoreTeamA +=2
            score.score_A = scoreViewModel.scoreTeamA.toString()
            binding.team = score
        }
        bt_team_b_2_p.setOnClickListener {
            scoreViewModel.scoreTeamB +=2
            score.score_B = scoreViewModel.scoreTeamA.toString()
            binding.team = score
        }

        bt_team_a_3_p.setOnClickListener {
            scoreViewModel.scoreTeamA +=3
            score.score_A = scoreViewModel.scoreTeamA.toString()
            binding.team = score
        }
        bt_team_b_3_p.setOnClickListener {
            scoreViewModel.scoreTeamB +=3
            score.score_B = scoreViewModel.scoreTeamA.toString()
            binding.team = score
        }

        bt_reset.setOnClickListener {
            scoreViewModel.scoreTeamA = 0
            scoreViewModel.scoreTeamB = 0
            score.score_A = scoreViewModel.scoreTeamA.toString()
            score.score_B = scoreViewModel.scoreTeamB.toString()
            binding.team = score
        }
    }

}
