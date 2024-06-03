package com.example.gameproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TooltipCompat;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class game extends AppCompatActivity {
    TypeWriter typeWriter;
    Button btn1;
    Button btn2;
    Button btn3;
 //   ImageButton info;
//    ProgressBar happiness;
    TextView tvPoints;
    ImageView charImg;
    ImageView background;
    TextView ochki;
    public int score = 0;
    public boolean btn1Touched=false;
    public boolean btn2Touched=false;
    public boolean btn3Touched=false;
    public int getScore() {
        return score;
    }

    public void HideButtons(){
        btn1.setVisibility(View.GONE);
        btn2.setVisibility(View.GONE);
        btn3.setVisibility(View.GONE);
    }
    public void ShowButtons(){
        AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(500);
        btn1.startAnimation(fadeIn);
        btn2.startAnimation(fadeIn);
        btn3.startAnimation(fadeIn);
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
    }
    public void Show2btn(){
        AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(500);
        btn1.startAnimation(fadeIn);
        btn2.startAnimation(fadeIn);
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
    }
    public void hideAllPic(){
        AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(500);
        background.startAnimation(fadeIn);
        background.setImageResource(0);
        charImg.startAnimation(fadeIn);
        charImg.setImageResource(0);

    }
    public void plusScore() {
        score += 10;
        tvPoints.setText(String.valueOf(score));}
    public void minusScore() {
        if (score>5){
        score -= 10;
        tvPoints.setText(String.valueOf(score));}}
    public void plusScore5() {
        score += 5;
        tvPoints.setText(String.valueOf(score));}
    public void minusScore5() {
        if(score>0){
        score -= 5;
        tvPoints.setText(String.valueOf(score));}}
    public void toStart() {
        Intent intent = new Intent(game.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, 0);
    }
    public void ResetTouched(){
        btn1Touched=false;
        btn2Touched=false;
        btn3Touched=false;
    }
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
//        info = findViewById(R.id.btnInfo);
        typeWriter=findViewById(R.id.text);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
//        happiness=findViewById(R.id.happiness);
        tvPoints=findViewById(R.id.tvPoints);
        ochki=findViewById(R.id.vashiOchki);
        charImg=findViewById(R.id.charImg);
        background=findViewById(R.id.background);
        View content = findViewById(android.R.id.content);

        int schelchok = getResources().getIdentifier("schelchok", "raw", getPackageName());
        MediaPlayer mediaSchelk=MediaPlayer.create(this, schelchok);
        int opendoor = getResources().getIdentifier("opendoor","raw",getPackageName());
        MediaPlayer mediaOpenDoor=MediaPlayer.create(this,opendoor);
        int lockdoor = getResources().getIdentifier("lockdoor","raw",getPackageName());
        MediaPlayer mediaLockDoor=MediaPlayer.create(this,lockdoor);
        int lockdoorsystem = getResources().getIdentifier("lockdoorsystem","raw",getPackageName());
        MediaPlayer MediaLockDoorSystem=MediaPlayer.create(this,lockdoorsystem);
        int a_question = getResources().getIdentifier("a_question", "raw", getPackageName());
        MediaPlayer mediaa_question=MediaPlayer.create(this, a_question);
        int thinking = getResources().getIdentifier("thinking", "raw", getPackageName());
        MediaPlayer mediaThinking=MediaPlayer.create(this, thinking );
        int scared= getResources().getIdentifier("scared", "raw", getPackageName());
        MediaPlayer mediaScared=MediaPlayer.create(this, scared);
        int phone= getResources().getIdentifier("phone", "raw", getPackageName());
        MediaPlayer mediaPhone=MediaPlayer.create(this, phone);
        int c_thinking= getResources().getIdentifier("c_thinking", "raw", getPackageName());
        MediaPlayer mediaC_thinking=MediaPlayer.create(this, c_thinking);
        int mhm= getResources().getIdentifier("mhm", "raw", getPackageName());
        MediaPlayer mediaMhm=MediaPlayer.create(this, mhm);

        AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(500);

        typeWriter.animateText("*Чей-то голос*\nЛадно, я пройдусь посмотрю весь дом.");

        btn1.setVisibility(View.GONE);
        btn2.setVisibility(View.GONE);
        btn3.setVisibility(View.GONE);
//        happiness.setVisibility(View.GONE);

        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (typeWriter.isAnimating) {
                    typeWriter.skipAnim();
                } else if (typeWriter.isTextFullyDisplayed()) {
                    typeWriter.animateText("*Другой голос*\nХорошо, если что, я здесь буду");
                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (typeWriter.isAnimating) {
                                typeWriter.skipAnim();
                            } else if (typeWriter.isTextFullyDisplayed()) {
                                typeWriter.animateText("*первый голос*\nХорошо-о");
                                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (typeWriter.isAnimating) {
                                            typeWriter.skipAnim();
                                        } else if (typeWriter.isTextFullyDisplayed()) {
                                            typeWriter.setTextColor(Color.parseColor("#ff0000"));
                                            typeWriter.animateText("*система*\nВ ПОМЕЩЕНИИ ОБНАРУЖЕНЫ ПОСТОРОННИЕ ЛЮДИ! АКТИВАЦИЯ РЕЖИМА БЕЗОПАСНОСТИ!");
                                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    if (typeWriter.isAnimating) {
                                                        typeWriter.skipAnim();
                                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                                        MediaLockDoorSystem.start();
                                                        typeWriter.setTextColor(Color.parseColor("#FFFFFF"));
                                                        typeWriter.animateText("*Все двери и окна резко закрылись.*");
                                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                if (typeWriter.isAnimating) {
                                                                    typeWriter.skipAnim();
                                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                                    MediaLockDoorSystem.release();
                                                                    charImg.startAnimation(fadeIn);
                                                                    background.startAnimation(fadeIn);
                                                                    charImg.setImageResource(R.drawable.l_angry2);
                                                                    background.setImageResource(R.drawable.background2);
                                                                    mediaa_question.start();
                                                                    typeWriter.animateText("Ну и что это сейчас было!? Теперь мы тут заперты!");
                                                                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                        @Override
                                                                        public void onClick(View v) {
                                                                            if (typeWriter.isAnimating) {
                                                                                typeWriter.skipAnim();
                                                                            } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                mediaa_question.release();
                                                                                charImg.setImageResource(R.drawable.l_think_speak);
                                                                                typeWriter.animateText("Надо что-то придумать.");
                                                                                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                    @Override
                                                                                    public void onClick(View v) {
                                                                                        if (typeWriter.isAnimating) {
                                                                                            typeWriter.skipAnim();
                                                                                        } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                            charImg.setImageResource(R.drawable.m_sad);
                                                                                            mediaScared.start();
                                                                                            typeWriter.animateText("ААААА! ЗВОНИ СПАСАТЕЛЯМ! ВДРУГ МЫ ТУТ ОСТАНЕМСЯ НАВСЕГДА!");
                                                                                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                @Override
                                                                                                public void onClick(View v) {
                                                                                                    if (typeWriter.isAnimating) {
                                                                                                        typeWriter.skipAnim();
                                                                                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                        mediaScared.release();
                                                                                                        charImg.setImageResource(R.drawable.l_phone_speak);
                                                                                                        typeWriter.animateText("Спасателям звонить не вариант..Что мы вообще им скажем? «Нас запер собственный дом и мы не знаем как выбраться»? А вдруг подумают что мы воры!");
                                                                                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                            @Override
                                                                                                            public void onClick(View v) {
                                                                                                                if (typeWriter.isAnimating) {
                                                                                                                    typeWriter.skipAnim();
                                                                                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                    charImg.setImageResource(R.drawable.m_scared);
                                                                                                                    typeWriter.animateText("А что делать тогда!?");
                                                                                                                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                        @Override
                                                                                                                        public void onClick(View v) {
                                                                                                                            if (typeWriter.isAnimating) {
                                                                                                                                typeWriter.skipAnim();
                                                                                                                            } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                charImg.setImageResource(R.drawable.l_def_phone);
                                                                                                                                mediaThinking.start();
                                                                                                                                typeWriter.animateText("Нужно связаться с Черром");
                                                                                                                                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                    @Override
                                                                                                                                    public void onClick(View v) {
                                                                                                                                        if (typeWriter.isAnimating) {
                                                                                                                                            typeWriter.skipAnim();
                                                                                                                                        } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                            mediaThinking.release();
                                                                                                                                            charImg.setImageResource(0);
                                                                                                                                            charImg.startAnimation(fadeIn);
                                                                                                                                            background.setImageResource(0);
                                                                                                                                            background.startAnimation(fadeIn);
                                                                                                                                            typeWriter.animateText("*Тем временем в комнате Черра.*");
                                                                                                                                            Toast.makeText(getApplicationContext(), "Теперь вы играете за персонажа по имени Черр!", Toast.LENGTH_LONG).show();
                                                                                                                                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                                @Override
                                                                                                                                                public void onClick(View v) {
                                                                                                                                                    if (typeWriter.isAnimating) {
                                                                                                                                                        typeWriter.skipAnim();
                                                                                                                                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                        typeWriter.animateText("*Черр сидел за ноутбуком и как раз смотрел код для умного дома*");
                                                                                                                                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                                            @Override
                                                                                                                                                            public void onClick(View v) {
                                                                                                                                                                if (typeWriter.isAnimating) {
                                                                                                                                                                    typeWriter.skipAnim();
                                                                                                                                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                                    background.startAnimation(fadeIn);
                                                                                                                                                                    background.setImageResource(R.drawable.background3);
                                                                                                                                                                    charImg.setImageResource(R.drawable.c_think_speak);
                                                                                                                                                                    mediaC_thinking.start();
                                                                                                                                                                    typeWriter.animateText("Что-то тут не так...Почему он выдает угрозу...");
                                                                                                                                                                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                                                        @Override
                                                                                                                                                                        public void onClick(View v) {
                                                                                                                                                                            if (typeWriter.isAnimating) {
                                                                                                                                                                                typeWriter.skipAnim();
                                                                                                                                                                            } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                                                mediaC_thinking.release();
                                                                                                                                                                                typeWriter.animateText("Надо связаться с...");
                                                                                                                                                                                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                                                                    @Override
                                                                                                                                                                                    public void onClick(View v) {
                                                                                                                                                                                        if (typeWriter.isAnimating) {
                                                                                                                                                                                            typeWriter.skipAnim();
                                                                                                                                                                                        } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                                                            btn1.setText("Латаром");
                                                                                                                                                                                            btn2.setText("Мисуро");
                                                                                                                                                                                            btn1.startAnimation(fadeIn);
                                                                                                                                                                                            btn2.startAnimation(fadeIn);
                                                                                                                                                                                            btn1.setVisibility(View.VISIBLE);
                                                                                                                                                                                            btn2.setVisibility(View.VISIBLE);
                                                                                                                                                                                            content.setEnabled(false);
                                                                                                                                                                                            View.OnClickListener btnClickListener = new View.OnClickListener() {
                                                                                                                                                                                                @Override
                                                                                                                                                                                                public void onClick(View v) {
                                                                                                                                                                                                    // обработка нажатия кнопок
                                                                                                                                                                                                    if (v == btn1) {
                                                                                                                                                                                                        mediaPhone.start();
                                                                                                                                                                                                        plusScore();
                                                                                                                                                                                                        btn1.setVisibility(View.GONE);
                                                                                                                                                                                                        btn2.setVisibility(View.GONE);
                                                                                                                                                                                                        charImg.setImageResource(0);
                                                                                                                                                                                                        charImg.startAnimation(fadeIn);
                                                                                                                                                                                                        background.setImageResource(0);
                                                                                                                                                                                                        background.startAnimation(fadeIn);
                                                                                                                                                                                                        typeWriter.animateText("*Вы звоните Латару...*");
                                                                                                                                                                                                        content.setEnabled(true);
                                                                                                                                                                                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                                                                                            @Override
                                                                                                                                                                                                            public void onClick(View v) {
                                                                                                                                                                                                                if (typeWriter.isAnimating) {
                                                                                                                                                                                                                    typeWriter.skipAnim();
                                                                                                                                                                                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                                                                                    mediaPhone.stop();
                                                                                                                                                                                                                    mediaPhone.release();
                                                                                                                                                                                                                    charImg.startAnimation(fadeIn);
                                                                                                                                                                                                                    background.startAnimation(fadeIn);
                                                                                                                                                                                                                    background.setImageResource(R.drawable.background2);
                                                                                                                                                                                                                    charImg.setImageResource(R.drawable.l_def_phone);
                                                                                                                                                                                                                    typeWriter.animateText("А вот и как раз он звонит!");
                                                                                                                                                                                                                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                                                                                                        @Override
                                                                                                                                                                                                                        public void onClick(View v) {
                                                                                                                                                                                                                            if (typeWriter.isAnimating) {
                                                                                                                                                                                                                                typeWriter.skipAnim();
                                                                                                                                                                                                                            } else if(typeWriter.isTextFullyDisplayed()){
                                                                                                                                                                                                                                episode1();
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    });
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        });
                                                                                                                                                                                                    } else if (v == btn2) {
                                                                                                                                                                                                        mediaPhone.start();
                                                                                                                                                                                                        plusScore();
                                                                                                                                                                                                        btn1.setVisibility(View.GONE);
                                                                                                                                                                                                        btn2.setVisibility(View.GONE);
                                                                                                                                                                                                        charImg.setImageResource(0);
                                                                                                                                                                                                        charImg.startAnimation(fadeIn);
                                                                                                                                                                                                        background.setImageResource(0);
                                                                                                                                                                                                        background.startAnimation(fadeIn);
                                                                                                                                                                                                        typeWriter.animateText("*Вы звоните Мисуро...*");
                                                                                                                                                                                                        content.setEnabled(true);
                                                                                                                                                                                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                                                                                            @Override
                                                                                                                                                                                                            public void onClick(View v) {
                                                                                                                                                                                                                if (typeWriter.isAnimating) {
                                                                                                                                                                                                                    typeWriter.skipAnim();
                                                                                                                                                                                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                                                                                    mediaPhone.stop();
                                                                                                                                                                                                                    mediaPhone.release();
                                                                                                                                                                                                                    charImg.startAnimation(fadeIn);
                                                                                                                                                                                                                    background.startAnimation(fadeIn);
                                                                                                                                                                                                                    background.setImageResource(R.drawable.background2);
                                                                                                                                                                                                                    charImg.setImageResource(R.drawable.m_def_phone);
                                                                                                                                                                                                                    typeWriter.animateText("А вот и он звонит...");
                                                                                                                                                                                                                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                                                                                                        @Override
                                                                                                                                                                                                                        public void onClick(View v) {
                                                                                                                                                                                                                            if (typeWriter.isAnimating) {
                                                                                                                                                                                                                                typeWriter.skipAnim();
                                                                                                                                                                                                                            } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                                                                                                charImg.setImageResource(R.drawable.l_angry);
                                                                                                                                                                                                                                typeWriter.animateText("Да? А ну-ка, дай я отвечу.");
                                                                                                                                                                                                                                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                                    public void onClick(View v) {
                                                                                                                                                                                                                                        if (typeWriter.isAnimating) {
                                                                                                                                                                                                                                            typeWriter.skipAnim();
                                                                                                                                                                                                                                        } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                                                                                                            episode1();
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                });
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    });
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        });
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            };
                                                                                                                                                                                            btn1.setOnClickListener(btnClickListener);
                                                                                                                                                                                            btn2.setOnClickListener(btnClickListener);

                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            });
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                });
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    });
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        });
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            });
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                });
                                                                                                                            }
                                                                                                                        }
                                                                                                                    });
                                                                                                                }
                                                                                                            }
                                                                                                        });
                                                                                                    }
                                                                                                }
                                                                                            });
                                                                                        }
                                                                                    }
                                                                                });
                                                                            }
                                                                        }
                                                                    });
                                                                }
                                                            }
                                                        });
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
    private void episode1() {
        int mhm= getResources().getIdentifier("mhm", "raw", getPackageName());
        MediaPlayer mediaMhm=MediaPlayer.create(this, mhm);
        int haha= getResources().getIdentifier("haha", "raw", getPackageName());
        MediaPlayer mediaHaha=MediaPlayer.create(this,haha);

        View content = findViewById(android.R.id.content);
        AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(500);
        charImg.setImageResource(R.drawable.l_def_phone);
        typeWriter.animateText("Черр:\nЯ хотел сказать вам, чтобы вы там в доме были поосторожнее...");
        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (typeWriter.isAnimating) {
                    typeWriter.skipAnim();
                } else if (typeWriter.isTextFullyDisplayed()) {
                    charImg.setImageResource(R.drawable.l_angry);
                    typeWriter.animateText("Как ты вовремя, конечно!");
                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (typeWriter.isAnimating) {
                                typeWriter.skipAnim();
                            } else if (typeWriter.isTextFullyDisplayed()) {
                                charImg.setImageResource(R.drawable.l_def_phone);
                                typeWriter.animateText("Черр:\nЯ так понимаю, вы там застряли?");
                                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (typeWriter.isAnimating) {
                                            typeWriter.skipAnim();
                                        } else if (typeWriter.isTextFullyDisplayed()) {
                                            charImg.setImageResource(R.drawable.l_angry2);
                                            typeWriter.animateText("Какой ты у нас догадливый! Говори сразу, это твоих рук дело!?");
                                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    if (typeWriter.isAnimating) {
                                                        typeWriter.skipAnim();
                                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                                        charImg.setImageResource(R.drawable.l_angry);
                                                        typeWriter.animateText("Черр:\nУспокойся ты. Почему сразу я виноват!? Система безопасности обнаружила кого-то постороннего на территории дома и поэтому активировала режим безопасности...");
                                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                if (typeWriter.isAnimating) {
                                                                    typeWriter.skipAnim();
                                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                                    mediaMhm.start();
                                                                    charImg.setImageResource(R.drawable.l_scared);
                                                                    typeWriter.animateText("Так просто перезагрузи систему, а потом по камерам посмотришь кто это был.");
                                                                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                        @Override
                                                                        public void onClick(View v) {
                                                                            if (typeWriter.isAnimating) {
                                                                                typeWriter.skipAnim();
                                                                            } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                mediaMhm.release();
                                                                                typeWriter.startAnimation(fadeIn);
                                                                                typeWriter.setText("");
                                                                                background.startAnimation(fadeIn);
                                                                                background.setImageResource(0);
                                                                                charImg.startAnimation(fadeIn);
                                                                                charImg.setImageResource(0);
                                                                                background.startAnimation(fadeIn);
                                                                                background.setImageResource(R.drawable.background3);
                                                                                charImg.startAnimation(fadeIn);
                                                                                charImg.setImageResource(R.drawable.c_def_speak);
                                                                                typeWriter.animateText("Не всё так просто, знаешь ли. Похоже это был не просто прохожий. Хотя..было бы странно, если бы оказалось так. Ну так в чем суть...скорее всего он и задумывал запереть вас.");
                                                                                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                    @Override
                                                                                    public void onClick(View v) {
                                                                                        if (typeWriter.isAnimating) {
                                                                                            typeWriter.skipAnim();
                                                                                        } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                            typeWriter.startAnimation(fadeIn);
                                                                                            typeWriter.setText("");
                                                                                            background.startAnimation(fadeIn);
                                                                                            background.setImageResource(0);
                                                                                            charImg.startAnimation(fadeIn);
                                                                                            charImg.setImageResource(0);
                                                                                            background.startAnimation(fadeIn);
                                                                                            background.setImageResource(R.drawable.background2);
                                                                                            charImg.startAnimation(fadeIn);
                                                                                            charImg.setImageResource(R.drawable.l_scared);
                                                                                            typeWriter.animateText("Ладно, понял. Поможешь нам выбраться отсюда?");
                                                                                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                @Override
                                                                                                public void onClick(View v) {
                                                                                                    if (typeWriter.isAnimating) {
                                                                                                        typeWriter.skipAnim();
                                                                                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                        typeWriter.startAnimation(fadeIn);
                                                                                                        typeWriter.setText("");
                                                                                                        background.startAnimation(fadeIn);
                                                                                                        background.setImageResource(0);
                                                                                                        charImg.startAnimation(fadeIn);
                                                                                                        charImg.setImageResource(0);
                                                                                                        background.startAnimation(fadeIn);
                                                                                                        background.setImageResource(R.drawable.background3);
                                                                                                        charImg.startAnimation(fadeIn);
                                                                                                        charImg.setImageResource(R.drawable.c_think_speak);
                                                                                                        typeWriter.animateText("Помочь им выбраться?");
                                                                                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                            @Override
                                                                                                            public void onClick(View v) {
                                                                                                                if (typeWriter.isAnimating) {
                                                                                                                    typeWriter.skipAnim();
                                                                                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                    btn1.setText("Да");
                                                                                                                    btn2.setText("Нет");
                                                                                                                    btn1.startAnimation(fadeIn);
                                                                                                                    btn2.startAnimation(fadeIn);
                                                                                                                    btn1.setVisibility(View.VISIBLE);
                                                                                                                    btn2.setVisibility(View.VISIBLE);
                                                                                                                    content.setEnabled(false);
                                                                                                                    btn1.setOnClickListener(new View.OnClickListener() {
                                                                                                                        @Override
                                                                                                                        public void onClick(View v) {
                                                                                                                            mediaHaha.start();
                                                                                                                            btn1.setVisibility(View.GONE);
                                                                                                                            btn2.setVisibility(View.GONE);
                                                                                                                            plusScore();
                                                                                                                            content.setEnabled(true);
                                                                                                                            typeWriter.startAnimation(fadeIn);
                                                                                                                            typeWriter.setText("");
                                                                                                                            background.startAnimation(fadeIn);
                                                                                                                            background.setImageResource(0);
                                                                                                                            charImg.startAnimation(fadeIn);
                                                                                                                            charImg.setImageResource(0);
                                                                                                                            background.startAnimation(fadeIn);
                                                                                                                            background.setImageResource(R.drawable.background2);
                                                                                                                            charImg.startAnimation(fadeIn);
                                                                                                                            charImg.setImageResource(R.drawable.l_happy);
                                                                                                                            typeWriter.animateText("Отлично. Тогда мы на связи и ждем твоих указаний!");
                                                                                                                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                @Override
                                                                                                                                public void onClick(View v) {
                                                                                                                                    if (typeWriter.isAnimating) {
                                                                                                                                        typeWriter.skipAnim();
                                                                                                                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                        mediaHaha.release();
                                                                                                                                        typeWriter.startAnimation(fadeIn);
                                                                                                                                        typeWriter.setText("");
                                                                                                                                        background.startAnimation(fadeIn);
                                                                                                                                        background.setImageResource(0);
                                                                                                                                        charImg.startAnimation(fadeIn);
                                                                                                                                        charImg.setImageResource(0);
                                                                                                                                        background.startAnimation(fadeIn);
                                                                                                                                        background.setImageResource(R.drawable.background3);
                                                                                                                                        charImg.startAnimation(fadeIn);
                                                                                                                                        charImg.setImageResource(R.drawable.c_phone_speak);
                                                                                                                                        typeWriter.animateText("Сейчас осмотрю дом по камерам...");
                                                                                                                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                            @Override
                                                                                                                                            public void onClick(View v) {
                                                                                                                                                if (typeWriter.isAnimating) {
                                                                                                                                                    typeWriter.skipAnim();
                                                                                                                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                    episode2();
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        });
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            });
                                                                                                                        }
                                                                                                                    });
                                                                                                                    btn2.setOnClickListener(new View.OnClickListener() {
                                                                                                                        @Override
                                                                                                                        public void onClick(View v) {
                                                                                                                            btn1.setVisibility(View.GONE);
                                                                                                                            btn2.setVisibility(View.GONE);
                                                                                                                            minusScore();
                                                                                                                            content.setEnabled(true);
                                                                                                                            typeWriter.startAnimation(fadeIn);
                                                                                                                            typeWriter.setText("");
                                                                                                                            background.startAnimation(fadeIn);
                                                                                                                            background.setImageResource(0);
                                                                                                                            charImg.startAnimation(fadeIn);
                                                                                                                            charImg.setImageResource(0);
                                                                                                                            background.startAnimation(fadeIn);
                                                                                                                            background.setImageResource(R.drawable.background2);
                                                                                                                            charImg.startAnimation(fadeIn);
                                                                                                                            charImg.setImageResource(R.drawable.l_angry2);
                                                                                                                            typeWriter.animateText("Что значит нет!? А нам тут тогда что делать? Не оставаться же нам! Отказы не принимаются!");
                                                                                                                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                @Override
                                                                                                                                public void onClick(View v) {
                                                                                                                                    if (typeWriter.isAnimating) {
                                                                                                                                        typeWriter.skipAnim();
                                                                                                                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                        charImg.setImageResource(R.drawable.l_angry);
                                                                                                                                        typeWriter.animateText("Черр:\nДа ладно-ладно. Что ты начинаешь? Я же просто пошутил.");
                                                                                                                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                            @Override
                                                                                                                                            public void onClick(View v) {
                                                                                                                                                if (typeWriter.isAnimating) {
                                                                                                                                                    typeWriter.skipAnim();
                                                                                                                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                    charImg.setImageResource(R.drawable.l_angry2);
                                                                                                                                                    typeWriter.animateText("Ха-ха. Очень смешно! Но нам с Мисуро сейчас как то не до шуток!");
                                                                                                                                                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                                        @Override
                                                                                                                                                        public void onClick(View v) {
                                                                                                                                                            if (typeWriter.isAnimating) {
                                                                                                                                                                typeWriter.skipAnim();
                                                                                                                                                            } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                                charImg.setImageResource(R.drawable.m_sad);
                                                                                                                                                                typeWriter.animateText("Латар, успокойся. Сейчас он нам поможет. Да ведь?");
                                                                                                                                                                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                                                    @Override
                                                                                                                                                                    public void onClick(View v) {
                                                                                                                                                                        if (typeWriter.isAnimating) {
                                                                                                                                                                            typeWriter.skipAnim();
                                                                                                                                                                        } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                                            typeWriter.startAnimation(fadeIn);
                                                                                                                                                                            typeWriter.setText("");
                                                                                                                                                                            background.startAnimation(fadeIn);
                                                                                                                                                                            background.setImageResource(0);
                                                                                                                                                                            charImg.startAnimation(fadeIn);
                                                                                                                                                                            charImg.setImageResource(0);
                                                                                                                                                                            background.startAnimation(fadeIn);
                                                                                                                                                                            background.setImageResource(R.drawable.background3);
                                                                                                                                                                            charImg.startAnimation(fadeIn);
                                                                                                                                                                            charImg.setImageResource(R.drawable.c_phone_speak);
                                                                                                                                                                            typeWriter.animateText("Да помогу я вам. Просто подождите пока я все по камерам осмотрю. Может найду выход какой нибудь...");
                                                                                                                                                                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                                                                @Override
                                                                                                                                                                                public void onClick(View v) {
                                                                                                                                                                                    if (typeWriter.isAnimating) {
                                                                                                                                                                                        typeWriter.skipAnim();
                                                                                                                                                                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                                                        background.startAnimation(fadeIn);
                                                                                                                                                                                        background.setImageResource(0);
                                                                                                                                                                                        charImg.startAnimation(fadeIn);
                                                                                                                                                                                        charImg.setImageResource(0);

                                                                                                                                                                                        episode2();
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            });
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                });
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    });
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        });
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            });
                                                                                                                        }
                                                                                                                    });

                                                                                                                }
                                                                                                            }
                                                                                                        });
                                                                                                    }
                                                                                                }
                                                                                            });
                                                                                        }
                                                                                    }
                                                                                });
                                                                            }
                                                                        }
                                                                    });
                                                                }
                                                            }
                                                        });
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
    }
    private void episode2(){
        int thinking = getResources().getIdentifier("thinking", "raw", getPackageName());
        MediaPlayer mediaThinking=MediaPlayer.create(this, thinking );
        int a_question = getResources().getIdentifier("a_question", "raw", getPackageName());
        MediaPlayer mediaa_question=MediaPlayer.create(this, a_question);
        int mhm= getResources().getIdentifier("mhm", "raw", getPackageName());
        MediaPlayer mediaMhm=MediaPlayer.create(this, mhm);
        int haha= getResources().getIdentifier("haha", "raw", getPackageName());
        MediaPlayer mediaHaha=MediaPlayer.create(this,haha);

        View content = findViewById(android.R.id.content);
        AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(500);
        hideAllPic();
        typeWriter.animateText("*Латар и Мисуро стали ждать новостей от Черра. Хоть плохих, хоть хороших...");
        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (typeWriter.isAnimating) {
                    typeWriter.skipAnim();
                } else if (typeWriter.isTextFullyDisplayed()) {
                    background.startAnimation(fadeIn);
                    background.setImageResource(R.drawable.background2);
                    charImg.startAnimation(fadeIn);
                    charImg.setImageResource(R.drawable.m_scared);
                    mediaThinking.start();
                    typeWriter.animateText("Как то он долго, не думаешь?");
                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (typeWriter.isAnimating) {
                                typeWriter.skipAnim();
                            } else if (typeWriter.isTextFullyDisplayed()) {
                                mediaThinking.release();
                                charImg.setImageResource(R.drawable.l_think_speak);
                                typeWriter.animateText("Может сбросил трубку?");
                                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (typeWriter.isAnimating) {
                                            typeWriter.skipAnim();
                                        } else if (typeWriter.isTextFullyDisplayed()) {
                                            charImg.setImageResource(R.drawable.l_def_phone);
                                            typeWriter.animateText("Сейчас посмотрим...");
                                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    if (typeWriter.isAnimating) {
                                                        typeWriter.skipAnim();
                                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                                        charImg.setImageResource(R.drawable.l_angry);
                                                        typeWriter.animateText("Ну конечно сбросил! Не хочет он нам помогать! Сейчас позвоню ему ещё раз.");
                                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                if (typeWriter.isAnimating) {
                                                                    typeWriter.skipAnim();
                                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                                    mediaa_question.start();
                                                                    charImg.setImageResource(R.drawable.l_scared);
                                                                    typeWriter.animateText("Что...В каком смысле нет связи!? Теперь нам выбираться отсюда самим и без чьей либо помощи!?");
                                                                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                        @Override
                                                                        public void onClick(View v) {
                                                                            if (typeWriter.isAnimating) {
                                                                                typeWriter.skipAnim();
                                                                            } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                mediaa_question.release();
                                                                                Toast.makeText(getApplicationContext(), "Теперь вы играете за Латара!", Toast.LENGTH_LONG).show();
                                                                                charImg.setImageResource(R.drawable.m_think_speak);
                                                                                typeWriter.animateText("Успокойся. Вы же вместе с Черром разрабатывали этот дом. Ты, наверное, знаешь лазейки тут. Мы обязательно выберемся отсюда!");
                                                                                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                    @Override
                                                                                    public void onClick(View v) {
                                                                                        if (typeWriter.isAnimating) {
                                                                                            typeWriter.skipAnim();
                                                                                        } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                            charImg.setImageResource(R.drawable.l_sad);
                                                                                            typeWriter.animateText("Надеюсь что получится...");
                                                                                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                @Override
                                                                                                public void onClick(View v) {
                                                                                                    if (typeWriter.isAnimating) {
                                                                                                        typeWriter.skipAnim();
                                                                                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                        mediaMhm.start();
                                                                                                        charImg.setImageResource(R.drawable.l_think_speak);
                                                                                                        typeWriter.animateText("Лазейки говоришь...");
                                                                                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                            @Override
                                                                                                            public void onClick(View v) {
                                                                                                                if (typeWriter.isAnimating) {
                                                                                                                    typeWriter.skipAnim();
                                                                                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                    mediaMhm.release();
                                                                                                                    mediaHaha.start();
                                                                                                                    charImg.setImageResource(R.drawable.l_happy);
                                                                                                                    typeWriter.animateText("Точно! Нам нужно попасть в кое какую комнату. Мы тут оставили ключи от двери где-то поблизости. Я точно помню что это какое-то НЕОБЫЧНОЕ место. О каком никто бы не додумался.");
                                                                                                                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                        @Override
                                                                                                                        public void onClick(View v) {
                                                                                                                            if (typeWriter.isAnimating) {
                                                                                                                                typeWriter.skipAnim();
                                                                                                                            } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                mediaHaha.release();
                                                                                                                                question1();
                                                                                                                            }
                                                                                                                        }
                                                                                                                    });
                                                                                                                }
                                                                                                            }
                                                                                                        });
                                                                                                    }
                                                                                                }
                                                                                            });
                                                                                        }
                                                                                    }
                                                                                });
                                                                            }
                                                                        }
                                                                    });
                                                                }
                                                            }
                                                        });
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
    }
    public void question1() {
        int lockdoor = getResources().getIdentifier("lockdoor","raw",getPackageName());
        MediaPlayer mediaLockDoor=MediaPlayer.create(this,lockdoor);

        View content = findViewById(android.R.id.content);
        AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(500);
        background.setImageResource(R.drawable.background2);
        charImg.setImageResource(R.drawable.l_think_speak);
        typeWriter.animateText("Осталось только вспомнить где они лежат.");
        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (typeWriter.isAnimating) {
                    typeWriter.skipAnim();
                } else if (typeWriter.isTextFullyDisplayed()) {
                    btn1.startAnimation(fadeIn);
                    btn2.startAnimation(fadeIn);
                    btn3.startAnimation(fadeIn);
                    btn1.setText("Посмотреть под ковром.");
                    btn2.setText("Посмотреть на столике рядом.");
                    btn3.setText("А это что за кнопка в стене?");
                    ShowButtons();
                    content.setEnabled(false);

                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(btn2Touched==true){
                                minusScore();
                            }else{
                                minusScore5();
                            }
                            hideAllPic();
                            HideButtons();
                            content.setEnabled(true);
                            typeWriter.animateText("Вы смотрите под ковром, но ключей там не оказалось...");
                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (typeWriter.isAnimating) {
                                        typeWriter.skipAnim();
                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                        btn1.setBackgroundColor(Color.parseColor("#9E9E9E"));
                                        btn1.setEnabled(false);
                                        btn1Touched=true;
                                        question1();
                                    }
                                }
                            });
                        }
                    });
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (btn1Touched==true){
                                minusScore();
                            }else{
                                minusScore5();
                            }
                            hideAllPic();
                            HideButtons();
                            content.setEnabled(true);
                            typeWriter.animateText("На столике ничего не было, кроме небольшого листочка с планировкой дома...");
                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (typeWriter.isAnimating) {
                                        typeWriter.skipAnim();
                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                        btn2.setBackgroundColor(Color.parseColor("#9E9E9E"));
                                        btn2.setEnabled(false);
                                        btn2Touched=true;
                                        question1();
                                    }
                                }
                            });
                        }
                    });
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaLockDoor.start();
                            plusScore();
                            hideAllPic();
                            HideButtons();
                            content.setEnabled(true);
                            typeWriter.animateText("*Вы нажимаете на кнопку и в стене открывается небольшое отделение, где лежала связка ключей*");
                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (typeWriter.isAnimating) {
                                        typeWriter.skipAnim();
                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                        mediaLockDoor.release();
                                        ResetTouched();
                                        episode3();
                                    }
                                }
                            });
                        }
                    });
                }
            }
        });
    }
    public void episode3(){
        int thinking = getResources().getIdentifier("thinking", "raw", getPackageName());
        MediaPlayer mediaThinking=MediaPlayer.create(this, thinking );

        View content = findViewById(android.R.id.content);
        AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(500);
        btn1.setBackgroundColor(Color.parseColor("#FFFFFF"));
        btn2.setBackgroundColor(Color.parseColor("#FFFFFF"));
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        charImg.startAnimation(fadeIn);
        background.startAnimation(fadeIn);
        charImg.setImageResource(R.drawable.l_happy);
        background.setImageResource(R.drawable.background2);
        typeWriter.animateText("Точно! Осталось только подобрать ключ к двери.");
        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (typeWriter.isAnimating) {
                    typeWriter.skipAnim();
                } else if (typeWriter.isTextFullyDisplayed()) {
                    mediaThinking.start();
                    charImg.setImageResource(R.drawable.m_def_speak);
                    typeWriter.animateText("Нам нужен длинный ключ с пластиной на конце.");
                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (typeWriter.isAnimating) {
                                typeWriter.skipAnim();
                            } else if (typeWriter.isTextFullyDisplayed()) {
                                mediaThinking.release();
                                question2();
                            }
                        }
                    });
                }
            }
        });
    }
    public void question2(){
        int opendoor = getResources().getIdentifier("opendoor","raw",getPackageName());
        MediaPlayer mediaOpenDoor=MediaPlayer.create(this,opendoor);

        View content = findViewById(android.R.id.content);
        charImg.setImageResource(R.drawable.l_think_speak);
        background.setImageResource(R.drawable.background2);
        typeWriter.animateText("Хммм...Какой же ключ правильный...");
        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (typeWriter.isAnimating) {
                    typeWriter.skipAnim();
                } else if (typeWriter.isTextFullyDisplayed()) {
                    btn1.setText("Небольшой плоский ключ");
                    btn2.setText("Длинный ключ с пластиной на конце");
                    btn3.setText("Небольшой ключ с пластиной сбоку");
                    ShowButtons();
                    content.setEnabled(false);

                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (btn3Touched==true){
                                minusScore();
                            }else{
                                minusScore5();
                            }
                            hideAllPic();
                            HideButtons();
                            content.setEnabled(true);
                            typeWriter.animateText("Нет, этот ключ не подходит. Нужно подобрать другой.");
                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (typeWriter.isAnimating) {
                                        typeWriter.skipAnim();
                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                        btn1.setBackgroundColor(Color.parseColor("#9E9E9E"));
                                        btn1.setEnabled(false);
                                        btn1Touched=true;
                                        question2();
                                    }
                                }
                            });
                        }
                    });
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaOpenDoor.start();
                            hideAllPic();
                            HideButtons();
                            content.setEnabled(true);
                            plusScore();
                            typeWriter.animateText("Да! Нужный ключ!");
                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (typeWriter.isAnimating) {
                                        typeWriter.skipAnim();
                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                        mediaOpenDoor.release();
                                        ResetTouched();
                                        episode4();
                                    }
                                }
                            });
                        }
                    });
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (btn1Touched==true){
                                minusScore();
                            }else{
                                minusScore5();
                            }
                            hideAllPic();
                            HideButtons();
                            content.setEnabled(true);
                            typeWriter.animateText("Нет, этот ключ не подходит. Нужно подобрать другой.");
                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (typeWriter.isAnimating) {
                                        typeWriter.skipAnim();
                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                        btn3.setBackgroundColor(Color.parseColor("#9E9E9E"));
                                        btn3.setEnabled(false);
                                        btn3Touched=true;
                                        question2();
                                    }
                                }
                            });
                        }
                    });
                }
            }
        });
    }
public void episode4(){
    int thinking = getResources().getIdentifier("thinking", "raw", getPackageName());
    MediaPlayer mediaThinking=MediaPlayer.create(this, thinking );

    View content = findViewById(android.R.id.content);
    AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
    fadeIn.setDuration(500);
    btn1.setBackgroundColor(Color.parseColor("#FFFFFF"));
    btn3.setBackgroundColor(Color.parseColor("#FFFFFF"));
    btn1.setEnabled(true);
    btn3.setEnabled(true);
    charImg.startAnimation(fadeIn);
    background.startAnimation(fadeIn);
    charImg.setImageResource(R.drawable.m_happy);
    background.setImageResource(R.drawable.background);
    typeWriter.animateText("Ура! Мы уже продвинулись немного вперёд! Что дальше будем делать? Хммм...");
    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (typeWriter.isAnimating) {
                typeWriter.skipAnim();
            } else if (typeWriter.isTextFullyDisplayed()) {
                mediaThinking.start();
                charImg.setImageResource(R.drawable.l_think_speak);
                typeWriter.animateText("В этой комнате тоже есть кое-что...");
                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (typeWriter.isAnimating) {
                            typeWriter.skipAnim();
                        } else if (typeWriter.isTextFullyDisplayed()) {
                            mediaThinking.release();
                            charImg.setImageResource(R.drawable.m_def_speak);
                            typeWriter.animateText("Что же? Я хочу уже побыстрее выбраться отсюда!");
                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (typeWriter.isAnimating) {
                                        typeWriter.skipAnim();
                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                        question3();
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    });
}
public void question3(){
    int lockdoor = getResources().getIdentifier("lockdoor","raw",getPackageName());
    MediaPlayer mediaLockDoor=MediaPlayer.create(this,lockdoor);
    int a_question = getResources().getIdentifier("a_question", "raw", getPackageName());
    MediaPlayer mediaa_question=MediaPlayer.create(this, a_question);
    int opendoor = getResources().getIdentifier("opendoor","raw",getPackageName());
    MediaPlayer mediaOpenDoor=MediaPlayer.create(this,opendoor);
    int haha= getResources().getIdentifier("haha", "raw", getPackageName());
    MediaPlayer mediaHaha=MediaPlayer.create(this,haha);
    int thinking = getResources().getIdentifier("thinking", "raw", getPackageName());
    MediaPlayer mediaThinking=MediaPlayer.create(this, thinking );


    View content = findViewById(android.R.id.content);
    AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
    fadeIn.setDuration(500);
    charImg.setImageResource(R.drawable.l_think_speak);
    typeWriter.animateText("Нужно осмотреть комнату...");
    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (typeWriter.isAnimating) {
                typeWriter.skipAnim();
            } else if (typeWriter.isTextFullyDisplayed()) {
                Show2btn();
                btn1.setText("Осмотреть стены.");
                btn2.setText("Осмотреть потолок.");
                content.setEnabled(false);

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaLockDoor.start();
                        plusScore5();
                        hideAllPic();
                        HideButtons();
                        content.setEnabled(true);
                        typeWriter.animateText("*На стене была картина. Но висела она криво, а из-за этого за ней виднелась какая то маленькая дверца...*");
                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (typeWriter.isAnimating) {
                                    typeWriter.skipAnim();
                                } else if (typeWriter.isTextFullyDisplayed()) {
                                    mediaLockDoor.release();
                                    if (btn2Touched==true){
                                        mediaOpenDoor.start();
                                        charImg.startAnimation(fadeIn);
                                        background.startAnimation(fadeIn);
                                        charImg.setImageResource(R.drawable.m_happy);
                                        background.setImageResource(R.drawable.background);
                                        typeWriter.animateText("Это же ключ! Наверное он как раз от двери на чердак!");
                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (typeWriter.isAnimating) {
                                                    typeWriter.skipAnim();
                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                    mediaOpenDoor.release();
                                                    hideAllPic();
                                                    ResetTouched();
                                                    episode5();
                                                }
                                            }
                                        });
                                    }else{
                                        mediaa_question.start();
                                        charImg.startAnimation(fadeIn);
                                        background.startAnimation(fadeIn);
                                        charImg.setImageResource(R.drawable.m_def_speak);
                                        background.setImageResource(R.drawable.background);
                                        typeWriter.animateText("Это же..ключ? Интересно от чего он...");
                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (typeWriter.isAnimating) {
                                                    typeWriter.skipAnim();
                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                    mediaa_question.release();
                                                    btn1Touched=true;
                                                    btn1.setBackgroundColor(Color.parseColor("#9E9E9E"));
                                                    btn1.setEnabled(false);
                                                    question3();
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                        });

                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        plusScore5();
                        hideAllPic();
                        HideButtons();
                        content.setEnabled(true);
                        typeWriter.animateText("*Вы стали осматривать потолок...*");
                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (typeWriter.isAnimating) {
                                    typeWriter.skipAnim();
                                } else if (typeWriter.isTextFullyDisplayed()) {
                                    if (btn1Touched==true) {
                                        charImg.startAnimation(fadeIn);
                                        background.startAnimation(fadeIn);
                                        charImg.setImageResource(R.drawable.m_def_speak);
                                        background.setImageResource(R.drawable.background);
                                        typeWriter.animateText("Там же чердак. Латар, есть ли там что-то, что поможет нам выбраться отсюда?");
                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (typeWriter.isAnimating) {
                                                    typeWriter.skipAnim();
                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                    charImg.setImageResource(R.drawable.l_think_speak);
                                                    typeWriter.animateText("Вообще там находится щиток и генератор для режима резервного питания..Точно! Нужно просто их отключить.");
                                                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            if (typeWriter.isAnimating) {
                                                                typeWriter.skipAnim();
                                                            } else if (typeWriter.isTextFullyDisplayed()) {
                                                                mediaHaha.start();
                                                                charImg.setImageResource(R.drawable.l_happy);
                                                                typeWriter.animateText("А ключ как раз от чердака!");
                                                                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        if (typeWriter.isAnimating) {
                                                                            typeWriter.skipAnim();
                                                                        } else if (typeWriter.isTextFullyDisplayed()) {
                                                                            mediaHaha.release();
                                                                            hideAllPic();
                                                                            ResetTouched();
                                                                            episode5();
                                                                        }
                                                                    }
                                                                });
                                                            }
                                                        }
                                                    });
                                                }
                                            }
                                        });
                                    }else{
                                        mediaThinking.start();
                                        charImg.startAnimation(fadeIn);
                                        background.startAnimation(fadeIn);
                                        charImg.setImageResource(R.drawable.l_def_speak);
                                        background.setImageResource(R.drawable.background);
                                        typeWriter.animateText("Чердак...Точно! Там же электрический щиток и генератор энергии. Нужно просто их отключить!");
                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (typeWriter.isAnimating) {
                                                    typeWriter.skipAnim();
                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                    mediaThinking.release();
                                                    charImg.setImageResource(R.drawable.m_sad);
                                                    typeWriter.animateText("Осталось только ключ от него найти...");
                                                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            if (typeWriter.isAnimating) {
                                                                typeWriter.skipAnim();
                                                            } else if (typeWriter.isTextFullyDisplayed()) {
                                                                btn2Touched=true;
                                                                btn2.setBackgroundColor(Color.parseColor("#9E9E9E"));
                                                                btn2.setEnabled(false);
                                                                question3();
                                                            }
                                                        }
                                                    });
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                        });
                    }
                });
            }
        }
    });
}
public void episode5(){
    int schelchok = getResources().getIdentifier("schelchok", "raw", getPackageName());
    MediaPlayer mediaSchelk=MediaPlayer.create(this, schelchok);
    int opendoor = getResources().getIdentifier("opendoor","raw",getPackageName());
    MediaPlayer mediaOpenDoor=MediaPlayer.create(this,opendoor);
    int lockdoor = getResources().getIdentifier("lockdoor","raw",getPackageName());
    MediaPlayer mediaLockDoor=MediaPlayer.create(this,lockdoor);
    int lockdoorsystem = getResources().getIdentifier("lockdoorsystem","raw",getPackageName());
    MediaPlayer MediaLockDoorSystem=MediaPlayer.create(this,lockdoorsystem);
    int a_question = getResources().getIdentifier("a_question", "raw", getPackageName());
    MediaPlayer mediaa_question=MediaPlayer.create(this, a_question);
    int thinking = getResources().getIdentifier("thinking", "raw", getPackageName());
    MediaPlayer mediaThinking=MediaPlayer.create(this, thinking );
    int scared= getResources().getIdentifier("scared", "raw", getPackageName());
    MediaPlayer mediaScared=MediaPlayer.create(this, scared);
    int phone= getResources().getIdentifier("phone", "raw", getPackageName());
    MediaPlayer mediaPhone=MediaPlayer.create(this, phone);
    int c_thinking= getResources().getIdentifier("c_thinking", "raw", getPackageName());
    MediaPlayer mediaC_thinking=MediaPlayer.create(this, c_thinking);
    int mhm= getResources().getIdentifier("mhm", "raw", getPackageName());
    MediaPlayer mediaMhm=MediaPlayer.create(this, mhm);

    int haha= getResources().getIdentifier("haha", "raw", getPackageName());
    MediaPlayer mediaHaha=MediaPlayer.create(this,haha);
    View content = findViewById(android.R.id.content);
    AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
    fadeIn.setDuration(500);
    btn1.setBackgroundColor(Color.parseColor("#FFFFFF"));
    btn1.setEnabled(true);
    btn2.setBackgroundColor(Color.parseColor("#FFFFFF"));
    btn2.setEnabled(true);
    background.startAnimation(fadeIn);
    charImg.startAnimation(fadeIn);
    background.setImageResource(R.drawable.background5);
    charImg.setImageResource(R.drawable.m_def_speak);
    mediaMhm.start();
    typeWriter.animateText("И так..Мы теперь на чердаке. Получается теперь нужно только найти щиток и генератор?");
    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (typeWriter.isAnimating) {
                typeWriter.skipAnim();
            } else if (typeWriter.isTextFullyDisplayed()) {
                mediaMhm.release();
                charImg.setImageResource(R.drawable.l_happy);
                typeWriter.animateText("Ага! Они тут поблизости должны быть.");
                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (typeWriter.isAnimating) {
                            typeWriter.skipAnim();
                        } else if (typeWriter.isTextFullyDisplayed()) {
                            charImg.setImageResource(R.drawable.m_think_speak);
                            typeWriter.animateText("Хорошо. Сейчас осмотрюсь...");
                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (typeWriter.isAnimating) {
                                        typeWriter.skipAnim();
                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                        charImg.setImageResource(R.drawable.m_def);
                                        typeWriter.animateText("...");
                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (typeWriter.isAnimating) {
                                                    typeWriter.skipAnim();
                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                    charImg.setImageResource(R.drawable.m_hand);
                                                    typeWriter.animateText("Нашёл! Они там, в углу!");
                                                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            if (typeWriter.isAnimating) {
                                                                typeWriter.skipAnim();
                                                            } else if (typeWriter.isTextFullyDisplayed()) {
                                                                mediaHaha.start();
                                                                charImg.setImageResource(R.drawable.l_happy);
                                                                typeWriter.animateText("Отлично! Теперь нужно отключить сначала генератор, а потом электричество. Если сделать наоборот, то система просто не даст нам отключить генератор.");
                                                                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        if (typeWriter.isAnimating) {
                                                                            typeWriter.skipAnim();
                                                                        } else if (typeWriter.isTextFullyDisplayed()) {
                                                                            mediaHaha.release();
                                                                            charImg.setImageResource(R.drawable.m_scared);
                                                                            typeWriter.animateText("Это значит что мы уже не сможем выбраться отсюда сами?");
                                                                            findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                @Override
                                                                                public void onClick(View v) {
                                                                                    if (typeWriter.isAnimating) {
                                                                                        typeWriter.skipAnim();
                                                                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                        charImg.setImageResource(R.drawable.l_def_speak);
                                                                                        typeWriter.animateText("Ну да...");
                                                                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                            @Override
                                                                                            public void onClick(View v) {
                                                                                                if (typeWriter.isAnimating) {
                                                                                                    typeWriter.skipAnim();
                                                                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                    charImg.setImageResource(R.drawable.l_angry);
                                                                                                    typeWriter.animateText("Всё, хватит обсуждать это всё. Пора отсюда уходить.");
                                                                                                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                        @Override
                                                                                                        public void onClick(View v) {
                                                                                                            if (typeWriter.isAnimating) {
                                                                                                                typeWriter.skipAnim();
                                                                                                            } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                mediaSchelk.start();
                                                                                                                hideAllPic();
                                                                                                                typeWriter.animateText("*Вы и Мисуро выключили генератор, а после и электрический щиток.*");
                                                                                                                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                    @Override
                                                                                                                    public void onClick(View v) {
                                                                                                                        if (typeWriter.isAnimating) {
                                                                                                                            typeWriter.skipAnim();
                                                                                                                        } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                            mediaSchelk.release();
                                                                                                                            typeWriter.setTextColor(Color.parseColor("#FF0000"));
                                                                                                                            typeWriter.animateText("Система:\nПИТАНИЕ ОТСУТСТВУЕТ! РЕЖИМ БЕЗОПАСНОСТИ ОТКЛЮЧЕН");findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                @Override
                                                                                                                                public void onClick(View v) {
                                                                                                                                    if (typeWriter.isAnimating) {
                                                                                                                                        typeWriter.skipAnim();
                                                                                                                                    } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                        typeWriter.setTextColor(Color.parseColor("#FFFFFF"));
                                                                                                                                        typeWriter.animateText("*Вы пошли к входной двери и она с лёгкостью открылась! А на вашем телефоне было 24 пропущенных от Черра*");
                                                                                                                                        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                            @Override
                                                                                                                                            public void onClick(View v) {
                                                                                                                                                if (typeWriter.isAnimating) {
                                                                                                                                                    typeWriter.skipAnim();
                                                                                                                                                } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                    background.startAnimation(fadeIn);
                                                                                                                                                    charImg.startAnimation(fadeIn);
                                                                                                                                                    background.setImageResource(R.drawable.background4);
                                                                                                                                                    charImg.setImageResource(R.drawable.m_happy);
                                                                                                                                                    typeWriter.animateText("Наконец-то мы выбрались!");
                                                                                                                                                    findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                                        @Override
                                                                                                                                                        public void onClick(View v) {
                                                                                                                                                            if (typeWriter.isAnimating) {
                                                                                                                                                                typeWriter.skipAnim();
                                                                                                                                                            } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                                charImg.setImageResource(R.drawable.l_angry);
                                                                                                                                                                typeWriter.animateText("В следующий раз нужно брать с собой Черра. А то, как оказалось, система безопасности так же начала блокировать сигнал.");
                                                                                                                                                                findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
                                                                                                                                                                    @Override
                                                                                                                                                                    public void onClick(View v) {
                                                                                                                                                                        if (typeWriter.isAnimating) {
                                                                                                                                                                            typeWriter.skipAnim();
                                                                                                                                                                        } else if (typeWriter.isTextFullyDisplayed()) {
                                                                                                                                                                            hideAllPic();
                                                                                                                                                                            theEnd();
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                });
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    });
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        });
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            });
                                                                                                                        }
                                                                                                                    }
                                                                                                                });
                                                                                                            }
                                                                                                        }
                                                                                                    });
                                                                                                }
                                                                                            }
                                                                                        });
                                                                                    }
                                                                                }
                                                                            });
                                                                        }
                                                                    }
                                                                });
                                                            }
                                                        }
                                                    });
                                                }
                                            }
                                        });
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    });
}
    public void theEnd() {
        Handler handler = new Handler();
        View content = findViewById(android.R.id.content);
        AlphaAnimation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(500);
        ochki.startAnimation(fadeIn);
        ochki.setVisibility(View.GONE);
        tvPoints.startAnimation(fadeIn);
        tvPoints.setVisibility(View.GONE);
        background.startAnimation(fadeIn);
        background.setImageResource(0);
        charImg.startAnimation(fadeIn);
        charImg.setImageResource(0);
        typeWriter.animateText("Конец!\nВы заработали " + String.valueOf(score) + " очков!\nНажмите в любую часть экрана чтобы вернуться на начальный экран.");
        findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (typeWriter.isAnimating) {
                    typeWriter.skipAnim();
                } else if (typeWriter.isTextFullyDisplayed()) {
                    toStart();
                }
            }
        });
    }
}