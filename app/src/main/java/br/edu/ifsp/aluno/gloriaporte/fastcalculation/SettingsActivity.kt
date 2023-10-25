package br.edu.ifsp.aluno.gloriaporte.fastcalculation


import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.aluno.gloriaporte.fastcalculation.Extras.EXTRA_SETTINGS
import br.edu.ifsp.aluno.gloriaporte.fastcalculation.databinding.ActivitySettingsBinding


class SettingsActivity : AppCompatActivity() {
    private val activitySettingsBinding: ActivitySettingsBinding by lazy {
        ActivitySettingsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activitySettingsBinding.root)

        setSupportActionBar(activitySettingsBinding.gameTbIn.gameToolbar)
        supportActionBar?.title = getString(R.string.app_name)
        supportActionBar?.subtitle = getString(R.string.settings)

        activitySettingsBinding.apply {
            letsGoButton.setOnClickListener {
                val settings = Settings(playerNameEditText.text.toString(),
                    (roundsSpinner.selectedView as TextView).text.toString().toInt(),
                    roundIntervalRadioGroup.run {
                        findViewById<RadioButton>(checkedRadioButtonId).text.toString()
                            .toLong() * 1000L
                    })
                val gameActivityIntent = Intent(this@SettingsActivity, GameActivity::class.java)
                gameActivityIntent.putExtra(EXTRA_SETTINGS, settings)
                startActivity(gameActivityIntent)
                finish()
            }
        }

    }
}