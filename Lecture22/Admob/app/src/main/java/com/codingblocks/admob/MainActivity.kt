package com.codingblocks.admob

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.ads.*
import com.google.android.gms.ads.reward.RewardItem
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RewardedVideoAdListener {

    val interstitialAd by lazy {
        InterstitialAd(this).apply {
            adUnitId = "ca-app-pub-3940256099942544/1033173712"
        }
    }
    lateinit var rewardedVideoAd: RewardedVideoAd
    val adRequest = AdRequest.Builder()
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, "ca-app-pub-9291391930070237~4650906667")

        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this)

        rewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", adRequest)

        rewardedVideoAd.rewardedVideoAdListener = this

        adView.loadAd(adRequest)

        interstitialAd.loadAd(adRequest)

        btnShow.setOnClickListener {
            if (interstitialAd.isLoaded) {
                interstitialAd.show()
            } else
                Toast.makeText(this, "You got lucky!", Toast.LENGTH_SHORT).show()
        }

        btnShowRewarded.setOnClickListener {
            if (rewardedVideoAd.isLoaded)
                rewardedVideoAd.show()
            else
                Toast.makeText(this, "You got lucky!", Toast.LENGTH_SHORT).show()
        }

//        interstitialAd.adUnitId = "ca-app-pub-9291391930070237/8377688246"


        interstitialAd.adListener = object : AdListener() {

            override fun onAdLoaded() {
                super.onAdLoaded()
            }

            override fun onAdOpened() {
                super.onAdOpened()
                Toast.makeText(baseContext, "Thanks!", Toast.LENGTH_SHORT).show()
            }

            override fun onAdClosed() {
                super.onAdClosed()
                interstitialAd.loadAd(adRequest)
            }

            override fun onAdFailedToLoad(code: Int) {
                super.onAdFailedToLoad(code)
                Log.e("TAG", "Failed to load $code")
            }
        }


        adView.adListener = object : AdListener() {

            override fun onAdFailedToLoad(code: Int) {
                Log.e("TAG", "Failed to load $code")
            }

            override fun onAdLoaded() {
                super.onAdLoaded()
                Log.e("TAG", "Ad Loaded")
            }

        }
    }

    override fun onRewardedVideoAdClosed() {
        rewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", adRequest)
    }

    override fun onRewardedVideoAdLeftApplication() {
        rewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", adRequest)
    }

    override fun onRewardedVideoAdLoaded() {
    }

    override fun onRewardedVideoAdOpened() {
    }

    override fun onRewardedVideoCompleted() {
        rewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", adRequest)
    }

    override fun onRewarded(reward: RewardItem?) {
        Log.e("TAG", "Reward is ${reward?.type} worth ${reward?.amount}")
    }

    override fun onRewardedVideoStarted() {
    }

    override fun onRewardedVideoAdFailedToLoad(code: Int) {
        Log.e("TAG", "Failed to load $code")
    }
}
