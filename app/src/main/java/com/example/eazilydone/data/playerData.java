package com.example.eazilydone.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class playerData {
    private static playerData instance;

    private boolean firstDialogue;
    private int moneyAmount;
    private String email;
    private playerData(){}
    private playerData(boolean firstDialogue, int moneyAmount,String email) {
        this.firstDialogue = firstDialogue;
        this.moneyAmount = moneyAmount;
        this.email=email;
    }
    public static synchronized playerData getInstance(Context context) {
        if (instance == null) {
            Log.d("TAG", "getInstance: " );
            SharedPreferences sharedPreferences = context.getSharedPreferences("PlayerData", Context.MODE_PRIVATE);
            boolean firstDialogue = sharedPreferences.getBoolean("firstDialogue", false);
            int moneyAmount = sharedPreferences.getInt("moneyAmount", 0);
            String email = sharedPreferences.getString("email", "");
            instance = new playerData(firstDialogue, moneyAmount,email);
        }
        return instance;
    }
    public void saveData(Context context) {
        Log.d("TAG", "saveData: ");
        SharedPreferences sharedPreferences = context.getSharedPreferences("PlayerData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("firstDialogue", firstDialogue);
        editor.putInt("moneyAmount", moneyAmount);
        editor.putString("email", email);
        editor.apply();
    }

    public boolean getfirstDialogue() {
        return firstDialogue;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public void setfirstDialogue(boolean firstDialogue) {
        this.firstDialogue = firstDialogue;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

}
