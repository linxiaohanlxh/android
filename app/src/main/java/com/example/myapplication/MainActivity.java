package com.example.myapplication;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 数字
     */
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    /**
     * 运算符
     */
    private Button plus_btn;
    private Button subtract_btn;
    private Button multiply_btn;
    private Button divide_btn;
    private Button equal_btn;
    private Button sqrt_btn;
    /**
     * 其他
     */
    private Button dot_btn;
    private Button oppo_btn;
    private Button delete_btn;
    private Button ac_btn;
    /**
     * 结果
     */
    private TextView inputText;
    private TextView resultTest;
    /**
     * 已经输入的字符
     */
    private String existedText = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();

    }

    /**
     * 初始化控件
     */
    private void initView() {
        /**
         * 数字
         */
        num0 = (Button) findViewById(R.id.num_zero);
        num1 = (Button) findViewById(R.id.num_one);
        num2 = (Button) findViewById(R.id.num_two);
        num3 = (Button) findViewById(R.id.num_three);
        num4 = (Button) findViewById(R.id.num_four);
        num5 = (Button) findViewById(R.id.num_five);
        num6 = (Button) findViewById(R.id.num_six);
        num7 = (Button) findViewById(R.id.num_seven);
        num8 = (Button) findViewById(R.id.num_eight);
        num9 = (Button) findViewById(R.id.num_nine);
        /**
         * 运算符
         */
        plus_btn = (Button) findViewById(R.id.plus_btn);
        subtract_btn = (Button) findViewById(R.id.subtract_btn);
        multiply_btn = (Button) findViewById(R.id.multiply_btn);
        divide_btn = (Button) findViewById(R.id.divide_btn);
        equal_btn = (Button) findViewById(R.id.equal_btn);
        sqrt_btn = (Button) findViewById(R.id.sqrt_btn);
        /**
         * 其他
         */
        dot_btn = (Button) findViewById(R.id.dot_btn);
        oppo_btn = (Button) findViewById(R.id.oppo_btn);
        delete_btn = (Button) findViewById(R.id.delete_btn);
        ac_btn = (Button) findViewById(R.id.ac_btn);
        /**
         * 输入和结果
         */
        inputText = findViewById(R.id.input_text);
        resultTest = findViewById(R.id.result_text);
        /**
         * 已经输入的字符
         */
        existedText = inputText.getText().toString();
    }

    /**
     * 初始化事件
     */
    private void initEvent() {
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);

        plus_btn.setOnClickListener(this);
        subtract_btn.setOnClickListener(this);
        multiply_btn.setOnClickListener(this);
        divide_btn.setOnClickListener(this);
        equal_btn.setOnClickListener(this);
        sqrt_btn.setOnClickListener(this);

        dot_btn.setOnClickListener(this);
        oppo_btn.setOnClickListener(this);
        delete_btn.setOnClickListener(this);
        ac_btn.setOnClickListener(this);
    }

    /**
     * 点击事件
     *
     * @param v 点击的控件
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            /**
             * 数字
             */
            case R.id.num_zero:
                String temp = "";
                //不能输入000000，但可以是0.00001
                if (existedText.length() > 0) {
                    if (existedText.charAt(existedText.length() - 1) == '0') {
                        for (int i = existedText.length() - 1; i >= 0; i--) {
                            if (existedText.charAt(i) > '0' && existedText.charAt(i) <= '9' || existedText.charAt(i) == '.') {
                                //存在小数点 可以加0 或有大于0的数
                                temp = "0";
                                break;
                            } else {
                                if (existedText.charAt(i) < '0' || existedText.charAt(i) > '9') {
                                    break;
                                }
                            }
                        }
                    } else { //末尾不是0可以加0
                        temp = "0";
                    }
                } else { //输入不为空时，可以加0
                    temp = "0";
                }
                existedText += temp;
                break;
            case R.id.num_one:
                if(existedText.length() > 0){
                    if(existedText.charAt(existedText.length()-1) == '0'){
                        if(existedText.length() == 1){
                            existedText = existedText.substring(0,existedText.length()-1);
                            existedText = existedText + "1";
                            break;
                        }
                        for(int i=existedText.length()-1;i>=0;i--){
                            if(existedText.charAt(i) == '+' || existedText.charAt(i) == '-' ||
                                    existedText.charAt(i) == '×' || existedText.charAt(i) == '÷'){
                                existedText = existedText.substring(0,existedText.length()-1);
                                existedText = existedText + "1";
                                break;
                            }
                            if(existedText.charAt(i) != '0'){
                                existedText += "1";
                                break;
                            }
                        }
                    }else{
                        existedText += "1";
                    }
                }else{
                    existedText += "1";
                }
                break;
            case R.id.num_two:
                if(existedText.length() > 0){
                    if(existedText.charAt(existedText.length()-1) == '0'){
                        if(existedText.length() == 1){
                            existedText = existedText.substring(0,existedText.length()-1);
                            existedText = existedText + "2";
                            break;
                        }
                        for(int i=existedText.length()-1;i>=0;i--){
                            if(existedText.charAt(i) == '+' || existedText.charAt(i) == '-' ||
                                    existedText.charAt(i) == '×' || existedText.charAt(i) == '÷'){
                                existedText = existedText.substring(0,existedText.length()-1);
                                existedText = existedText + "2";
                                break;
                            }
                            if(existedText.charAt(i) != '0'){
                                existedText += "2";
                                break;
                            }
                        }
                    }else{
                        existedText += "2";
                    }
                }else{
                    existedText += "2";
                }

                break;
            case R.id.num_three:
                if(existedText.length() > 0){
                    if(existedText.charAt(existedText.length()-1) == '0'){
                        if(existedText.length() == 1){
                            existedText = existedText.substring(0,existedText.length()-1);
                            existedText = existedText + "3";
                            break;
                        }
                        for(int i=existedText.length()-1;i>=0;i--){
                            if(existedText.charAt(i) == '+' || existedText.charAt(i) == '-' ||
                                    existedText.charAt(i) == '×' || existedText.charAt(i) == '÷'){
                                existedText = existedText.substring(0,existedText.length()-1);
                                existedText = existedText + "3";
                                break;
                            }
                            if(existedText.charAt(i) != '0'){
                                existedText += "3";
                                break;
                            }
                        }
                    }else{
                        existedText += "3";
                    }
                }else{
                    existedText += "3";
                }
                break;
            case R.id.num_four:
                if(existedText.length() > 0){
                    if(existedText.charAt(existedText.length()-1) == '0'){
                        if(existedText.length() == 1){
                            existedText = existedText.substring(0,existedText.length()-1);
                            existedText = existedText + "4";
                            break;
                        }
                        for(int i=existedText.length()-1;i>=0;i--){
                            if(existedText.charAt(i) == '+' || existedText.charAt(i) == '-' ||
                                    existedText.charAt(i) == '×' || existedText.charAt(i) == '÷'){
                                existedText = existedText.substring(0,existedText.length()-1);
                                existedText = existedText + "4";
                                break;
                            }
                            if(existedText.charAt(i) != '0'){
                                existedText += "4";
                                break;
                            }
                        }
                    }else{
                        existedText += "4";
                    }
                }else{
                    existedText += "4";
                }
                break;
            case R.id.num_five:
                if(existedText.length() > 0){
                    if(existedText.charAt(existedText.length()-1) == '0'){
                        if(existedText.length() == 1){
                            existedText = existedText.substring(0,existedText.length()-1);
                            existedText = existedText + "5";
                            break;
                        }
                        for(int i=existedText.length()-1;i>=0;i--){
                            if(existedText.charAt(i) == '+' || existedText.charAt(i) == '-' ||
                                    existedText.charAt(i) == '×' || existedText.charAt(i) == '÷'){
                                existedText = existedText.substring(0,existedText.length()-1);
                                existedText = existedText + "5";
                                break;
                            }
                            if(existedText.charAt(i) != '0'){
                                existedText += "5";
                                break;
                            }
                        }
                    }else{
                        existedText += "5";
                    }
                }else{
                    existedText += "5";
                }
                break;
            case R.id.num_six:
                if(existedText.length() > 0){
                    if(existedText.charAt(existedText.length()-1) == '0'){
                        if(existedText.length() == 1){
                            existedText = existedText.substring(0,existedText.length()-1);
                            existedText = existedText + "6";
                            break;
                        }
                        for(int i=existedText.length()-1;i>=0;i--){
                            if(existedText.charAt(i) == '+' || existedText.charAt(i) == '-' ||
                                    existedText.charAt(i) == '×' || existedText.charAt(i) == '÷'){
                                existedText = existedText.substring(0,existedText.length()-1);
                                existedText = existedText + "6";
                                break;
                            }
                            if(existedText.charAt(i) != '0'){
                                existedText += "6";
                                break;
                            }
                        }
                    }else{
                        existedText += "6";
                    }
                }else{
                    existedText += "6";
                }
                break;
            case R.id.num_seven:
                if(existedText.length() > 0){
                    if(existedText.charAt(existedText.length()-1) == '0'){
                        if(existedText.length() == 1){
                            existedText = existedText.substring(0,existedText.length()-1);
                            existedText = existedText + "7";
                            break;
                        }
                        for(int i=existedText.length()-1;i>=0;i--){
                            if(existedText.charAt(i) == '+' || existedText.charAt(i) == '-' ||
                                    existedText.charAt(i) == '×' || existedText.charAt(i) == '÷'){
                                existedText = existedText.substring(0,existedText.length()-1);
                                existedText = existedText + "7";
                                break;
                            }
                            if(existedText.charAt(i) != '0'){
                                existedText += "7";
                                break;
                            }
                        }
                    }else{
                        existedText += "7";
                    }
                }else{
                    existedText += "7";
                }
                break;
            case R.id.num_eight:
                if(existedText.length() > 0){
                    if(existedText.charAt(existedText.length()-1) == '0'){
                        if(existedText.length() == 1){
                            existedText = existedText.substring(0,existedText.length()-1);
                            existedText = existedText + "8";
                            break;
                        }
                        for(int i=existedText.length()-1;i>=0;i--){
                            if(existedText.charAt(i) == '+' || existedText.charAt(i) == '-' ||
                                    existedText.charAt(i) == '×' || existedText.charAt(i) == '÷'){
                                existedText = existedText.substring(0,existedText.length()-1);
                                existedText = existedText + "8";
                                break;
                            }
                            if(existedText.charAt(i) != '0'){
                                existedText += "8";
                                break;
                            }
                        }
                    }else{
                        existedText += "8";
                    }
                }else{
                    existedText += "8";
                }
                break;
            case R.id.num_nine:
                if(existedText.length() > 0){
                    if(existedText.charAt(existedText.length()-1) == '0'){
                        if(existedText.length() == 1){
                            existedText = existedText.substring(0,existedText.length()-1);
                            existedText = existedText + "9";
                            break;
                        }
                        for(int i=existedText.length()-1;i>=0;i--){
                            if(existedText.charAt(i) == '+' || existedText.charAt(i) == '-' ||
                                    existedText.charAt(i) == '×' || existedText.charAt(i) == '÷'){
                                existedText = existedText.substring(0,existedText.length()-1);
                                existedText = existedText + "9";
                                break;
                            }
                            if(existedText.charAt(i) != '0'){
                                existedText += "9";
                                break;
                            }
                        }
                    }else{
                        existedText += "9";
                    }
                }else{
                    existedText += "9";
                }
                break;
            /**
             * 运算符
             */
            case R.id.plus_btn:
                //ep为空，加号不能按
                if (existedText.equals("")) {
                    break;
                }
                //不能连续按两个加号
                if (existedText.charAt(existedText.length() - 1) == '+') {
                    break;
                }
                //前面是减号、乘号、除号时变成加号
                if (existedText.charAt(existedText.length() - 1) == '×' ||
                        existedText.charAt(existedText.length() - 1) == '÷' ||
                        existedText.charAt(existedText.length() - 1) == '-' ||
                        existedText.charAt(existedText.length() - 1) == '√') {
                    existedText = existedText.substring(0, existedText.length() - 1);
                    existedText += "+";
                    break;
                }

                existedText += "+";
                break;
            case R.id.subtract_btn:

                //不能连续按两个加号
                if (existedText.length() > 0) {
                    if (existedText.charAt(existedText.length() - 1) == '-') {
                        break;
                    }
                    //前面是减号、乘号、除号时变成加号
                    if (existedText.charAt(existedText.length() - 1) == '+') {
                        existedText = existedText.substring(0, existedText.length() - 1);
                        existedText += "-";
                        break;
                    }
                }
                existedText += "-";
                break;
            case R.id.multiply_btn:

                //ep为空，加号不能按
                if (existedText.equals("")) {
                    break;
                }
                //不能连续按两个加号
                if (existedText.charAt(existedText.length() - 1) == '×') {
                    break;
                }
                //前面是减号、乘号、除号时变成加号
                if (existedText.charAt(existedText.length() - 1) == '+' ||
                        existedText.charAt(existedText.length() - 1) == '÷' ||
                        existedText.charAt(existedText.length() - 1) == '-' ||
                        existedText.charAt(existedText.length() - 1) == '√') {
                    existedText = existedText.substring(0, existedText.length() - 1);
                    existedText += "×";
                    break;
                }

                existedText += "×";
                break;
            case R.id.divide_btn:

                //ep为空，加号不能按
                if (existedText.equals("")) {
                    break;
                }
                //不能连续按两个加号
                if (existedText.charAt(existedText.length() - 1) == '÷') {
                    break;
                }
                //前面是减号、乘号、除号时变成加号
                if (existedText.charAt(existedText.length() - 1) == '+' ||
                        existedText.charAt(existedText.length() - 1) == '×' ||
                        existedText.charAt(existedText.length() - 1) == '-' ||
                        existedText.charAt(existedText.length() - 1) == '√') {
                    existedText = existedText.substring(0, existedText.length() - 1);
                    existedText += "÷";
                    break;
                }

                existedText += "÷";
                break;
            case R.id.equal_btn:
                //输入框为空
                if(existedText.equals("")){
                    resultTest.setText("");
                    break;
                }

                if(resultTest.getText().toString().contains("E")){
                    break;
                }

                if(existedText.equals("错误")){
                    Toast.makeText(MainActivity.this, "错误", Toast.LENGTH_SHORT).show();
                    break;
                }

                if (!checkExpression(existedText)) {
                    Toast.makeText(MainActivity.this, "错误", Toast.LENGTH_SHORT ).show();
                    resultTest.setText("错误");
                } else {
                    String result = getResult(existedText);
                    if(result.equals(resultTest.getText())){
                        resultTest.setText("");
                        existedText = result;
                    }else{
                        resultTest.setText(result);
                    }
                }
                break;
            case R.id.sqrt_btn:
                //输入框为0
                if(existedText.length() == 0){
                    break;
                }
                if (!checkExpression(existedText)) {
                    Toast.makeText(MainActivity.this, "错误", Toast.LENGTH_SHORT).show();
                    resultTest.setText("错误");
                } else {
                    if (existedText.equals("")) {
                        break;
                    }
                    String result = getResult(existedText);
                    if (result.contains("-")) {
                        Toast.makeText(MainActivity.this, "错误", Toast.LENGTH_SHORT).show();
                        resultTest.setText("错误");
                    } else {
                        result = String.valueOf(Math.sqrt(Double.parseDouble(result)));
                        result = beautifyExpression(result);
                        resultTest.setText(result);
                        existedText = result;
                    }
                }
                break;

            /**
             * 其他
             */
            case R.id.dot_btn:
                //不能连续输入小数点
                if (existedText.length() > 0) {
                    if (existedText.charAt(existedText.length() - 1) == '.') {
                        break;
                    }
                }
                //输入小数点后，如果没有遇到运算符，则不能输入小数点
                if (existedText.contains(".")) {
                    int last = existedText.lastIndexOf(".");
                    for (int i = last + 1; i < existedText.length(); i++) {
                        if (existedText.charAt(i) > '9' || existedText.charAt(i) < '0') {
                            existedText += ".";
                            break;
                        }
                    }
                    break;
                }

                existedText += ".";
                break;
            case R.id.oppo_btn:
                //+/-
                //输入框为空，相当于负号
                if(existedText.equals("")) {
                    existedText += "-";
                }else{
                    if(existedText.indexOf("+",1) < 0 && existedText.indexOf("-",1) < 0 &&
                            existedText.indexOf("×",1) < 0 && existedText.indexOf("÷",1) < 0){
                        if(existedText.charAt(0) == '-'){
                            existedText = existedText.substring(1,existedText.length());
                        }else if(existedText.charAt(0) == '+'){
                            existedText = existedText.substring(1,existedText.length());
                            existedText = "-" + existedText;
                        }else if(existedText.charAt(0) != '×' && existedText.charAt(0) != '0' && existedText.charAt(0) != '÷'){
                            existedText = "-" + existedText;
                        }
                        break;
                    }

                    if(existedText.charAt(existedText.length()-1) == '-' ||
                            existedText.charAt(existedText.length()-1) == '+' ||
                            existedText.charAt(existedText.length()-1) == '×'||
                            existedText.charAt(existedText.length()-1) == '÷' ||
                            existedText.charAt(existedText.length()-1) == '.'){
                        break;
                    }


                    int i;
                    for(i = existedText.length()-1;i>=1;i--){
                        if(existedText.charAt(i) == '-' || existedText.charAt(i) == '+' ||
                                existedText.charAt(i) == '×'|| existedText.charAt(i) == '÷'){
                            break;
                        }
                    }

                    //存在运算符，改ep，不存在，按不动
                    if(i > 0){
                        String s1;
                        String s2;
                        if(existedText.charAt(i-1) == '-' || existedText.charAt(i-1) == '+' ||
                                existedText.charAt(i-1) == '×'|| existedText.charAt(i-1) == '÷'){
                            s1 = existedText.substring(0,i);
                            s2 = existedText.substring(i+1);
                            existedText = s1 + s2;
                        }else{
                            if(existedText.charAt(i) == '-'){
                                s1 = existedText.substring(0,i);
                                s2 = existedText.substring(i+1);
                                existedText = s1 + '+' + s2;
                            }else if(existedText.charAt(i) == '+'){
                                s1 = existedText.substring(0,i);
                                s2 = existedText.substring(i+1);
                                existedText = s1 + '-' + s2;
                            }else if(existedText.charAt(i) == '×'){
                                s1 = existedText.substring(0,i+1);
                                s2 = existedText.substring(i+1);
                                existedText = s1 + "-" + s2;
                            }else if(existedText.charAt(i) == '÷'){
                                s1 = existedText.substring(0,i+1);
                                s2 = existedText.substring(i+1);
                                existedText = s1 + "-" + s2;
                            }
                        }
                    }
                }

                break;
            case R.id.delete_btn:
                if (existedText.length() > 0) {
                    if (existedText.length() == 1) {
                        existedText = "";
                    } else {
                        existedText = existedText.substring(0, existedText.length() - 1);
                    }
                }
                break;
            case R.id.ac_btn:
                existedText = "";
                resultTest.setText("");
                break;
        }
        //重置输入框
        inputText.setText(existedText);
    }


    //判断ep是否正确
    public static boolean checkExpression(String expression) {
        //不能只有一个负数
        if (expression.length() == 1 && expression.charAt(0) == '-') {
            return false;
        }

        //不能开头是加号、减号、除号
        if (expression.charAt(0) == '+' || expression.charAt(0) == '×' || expression.charAt(0) == '÷') {
            return false;
        }

        //不能两个连续的运算符
        String regex_1 = ".*([+\\-÷×])+([+\\-÷×])+";
        Matcher m_1 = Pattern.compile(regex_1).matcher(expression);
        if (m_1.matches()) {
            return false;
        }

        //是否存在除数为0
        if (expression.indexOf("÷0") > 0) {
            //除数为0.003是可以的
            int p = expression.indexOf("÷0");
            int q = expression.indexOf("÷0.");
            int i;
            int flag = 0;
            while (p > 0) {
                if (q > 0) {
                    for (i = p + 3; i < expression.length(); i++) {
                        //遇到运算符之前，都是0，则报错
                        if (expression.charAt(i) < '0' || expression.charAt(i) > '9') {
                            flag = 0;
                            break;
                        }
                        if (expression.charAt(i) != '0') {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        return false;
                    }
                    p = expression.indexOf("÷0", i);
                    q = expression.indexOf("÷0.", i);
                    flag = 0;
                } else {
                    return false;
                }
            }
            return true;
        }
    //不能有÷-0、÷-0.
        if(expression.indexOf("÷-0") > 0){
            int p = expression.indexOf("÷-0");
            int i;
            int flag = 0;

            while(p > 0){
                //如果后面不是小数点，说明是一个/0
                if(p + 3 < expression.length()){
                    if(expression.charAt(p+3) != '.'){
                        flag = 0;
                        p = expression.indexOf("÷-0",p+3);
                    }else{
                        for (i = p + 4; i < expression.length(); i++) {
                            //遇到运算符之前，都是0，则报错
                            if (expression.charAt(i) < '0' || expression.charAt(i) > '9') {
                                flag = 0;
                                break;
                            }
                            if (expression.charAt(i) != '0') {
                                flag = 1;
                                break;
                            }
                        }
                        p = expression.indexOf("÷-0",i);
                    }
                    if(flag == 0){
                        return false;
                    }
                    flag = 0;
                }else{
                    return false;
                }
            }
            return true;
        }

        //不能有÷.0
        if(expression.indexOf("÷.0") > 0){
            int p = expression.indexOf("÷.0");
            int i;
            int flag = 0;

            while(p > 0){
                //如果后面不是小数点，说明是一个/0
                for (i = p + 3; i < expression.length(); i++) {
                    //遇到运算符之前，都是0，则报错
                    if (expression.charAt(i) < '0' || expression.charAt(i) > '9') {
                        flag = 0;
                        break;
                    }
                    if (expression.charAt(i) != '0') {
                        flag = 1;
                        break;
                    }
                }
                p = expression.indexOf("÷.0",i);
                if(flag == 0) {
                    return false;
                }
                flag = 0;
            }

            return true;
        }

        //不能有÷-.0
        if(expression.indexOf("÷-.0") > 0){
            int p = expression.indexOf("÷-.0");
            int i;
            int flag = 0;

            while(p > 0){
                //如果后面不是小数点，说明是一个/0
                for (i = p + 3; i < expression.length(); i++) {
                    //遇到运算符之前，都是0，则报错
                    if (expression.charAt(i) < '0' || expression.charAt(i) > '9') {
                        flag = 0;
                        break;
                    }
                    if (expression.charAt(i) != '0') {
                        flag = 1;
                        break;
                    }
                }
                p = expression.indexOf("÷-.0",i);
                if(flag == 0) {
                    return false;
                }
                flag = 0;
            }

            return true;
        }


        //非法输入 .+.
        String regex_2 = ".*(\\.)+([+\\-÷×])+(\\.)+.*";
        Matcher m_2 = Pattern.compile(regex_2).matcher(expression);
        if (m_2.matches()) {
            return false;
        }

        String regex_3 = ".*(\\.)+([+\\-÷×])+.*";
        Matcher m_3 = Pattern.compile(regex_3).matcher(expression);
        if (m_3.matches()) {
            return false;
        }



        //式子结尾是'.',则前一个字符不能不是数字
        if (expression.length() > 0) {
            if (expression.charAt(expression.length() - 1) == '.') {
                if ((expression.length() - 2) > 0) {
                    int p = expression.length() - 2;
                    if (expression.charAt(p) > '9' || expression.charAt(p) < '0') {
                        return false;
                    }
                } else { //只有一个.,也不行
                    return false;
                }
            }
        }

        return true;
    }

    //计算ep的值
    private String getResult(String expression) {
        //最后是运算符号，则删掉在传入栈
        if (expression.length() > 0) {
            if (expression.charAt(expression.length() - 1) == '+' ||
                    expression.charAt(expression.length() - 1) == '-' ||
                    expression.charAt(expression.length() - 1) == '×' ||
                    expression.charAt(expression.length() - 1) == '÷') {
                expression = expression.substring(0, expression.length() - 1);
            }
        }
        //开头是-，则在前面加个0在传入栈
        if(expression.charAt(0) == '-'){
            expression = 0 + expression;
        }

        //1*-2 --->1*(0-2)
        String regex_1 = ".*([+\\-÷×])+([+\\-÷×])+.*";
        Matcher m_1 = Pattern.compile(regex_1).matcher(expression);
        if(m_1.matches()) {
            String s1, s2;
            while(m_1.matches()){
                for (int i = expression.length() - 1;i>0; i--) {
                    if (expression.charAt(i) == '+' || expression.charAt(i) == '-' ||
                            expression.charAt(i) == '×' || expression.charAt(i) == '÷') {
                        if (expression.charAt(i - 1) == '+' || expression.charAt(i - 1) == '-' ||
                                expression.charAt(i - 1) == '×' || expression.charAt(i - 1) == '÷') {
                            s1 = expression.substring(0, i);
                            s2 = expression.substring(i);
                            expression = s1 + "(0" + s2 + ")";
                            break;
                        }
                    }
                }
                m_1 = Pattern.compile(regex_1).matcher(expression);
            }
        }

        //变成*/在传入栈
        expression = expression.replace("÷", "/");
        expression = expression.replace("×", "*");

        //计算
        Calculate_Stack c = new Calculate_Stack();
        expression = c.calculate(expression);

        //美化结果
        expression = beautifyExpression(expression);
        return expression;
    }

    //美化ep eg：1.0000 --> 1
    public static String beautifyExpression(String expression) {

        // eg:.3->0.3
        if (expression.charAt(0) == '.') {
            expression = "0" + expression;
        }

        if (expression.contains(".")) {
            int i = expression.length() - 1;
            while (expression.charAt(i) == '0') {
                expression = expression.substring(0, expression.length() - 1);
                i = expression.length() - 1;
            }
            if (expression.charAt(expression.length() - 1) == '.') {
                expression = expression.substring(0, expression.length() - 1);
            }
        }


        return expression;
    }
}
