import java.util.*;
import java.lang.*;
public class mafia {




        static int helper=0;
        public abstract class abs{
            Random r=new Random();
            ArrayList<player> plastic;
            abstract void assignrandom(ArrayList<player> pl);
            abstract void voting(ArrayList<player> pl,int e);
            abstract void ownvoting(ArrayList<player> p);
        }
        public class player{
            private int hp=0;
            private String character=null;
            private int index;
        }
        public class mafiagang extends abs{
            private int mhp=2500;
            private String mrole="Mafia";
            @Override
            void assignrandom(ArrayList<player> pl) {
                // TODO Auto-generated method stub
                for(int q=0;q<pl.size()/5;q++) {
                    int a=r.nextInt(pl.size());

                    int members=0;
                    for(int i=0;i<pl.size();i++) {
                        //	if(!(pl.get(i).character.equals(null))) {
                        if(pl.get(i).character.equals(mrole)){
                            members++;
                        }
                    }
                    int g=pl.size()/5;
                    if(members<g) {
                        if(pl.get(a).hp==0 && pl.get(a).character.equals("t")) {

                            pl.get(a).character=mrole;
                            pl.get(a).hp=mhp;
                            pl.get(a).index=a;

                        }
                        else {
                            q--;
                        }
                    }}}

            @Override
            void voting(ArrayList<player> p,int e) {
                int x=r.nextInt(p.size());
               int b= p.get(x).index+1;
               p.remove(x);
                System.out.println("Out voted player"+" "+b);
            }

            @Override
            void ownvoting(ArrayList<player> p) {
                int x=r.nextInt(p.size());
                int b= p.get(x).index+1;
                p.remove(x);
                System.out.println("Out voted player"+" "+b);
            }

            public int owneleminate(ArrayList<player> p) {
                int x=r.nextInt(p.size());
                int z=0;
                plastic=new ArrayList<player>(p.size());
                int initial=p.get(x).hp;
                for(int d=0;d<p.size();d++) {
                    if(p.get(d).character.equals("Mafia")) {
                        z=z+p.get(d).hp;
                        plastic.add(p.get(d));
                    }

                }
                if(z>=p.get(x).hp) {
                  //  tr=tr+x;
                    p.get(x).hp=0;
                 //   System.out.println(p.get(x).index+1+"is cm");

                }
                else {
                    p.get(x).hp=p.get(x).hp-z;
                  //  System.out.println(p.get(x).index+1 +" is cm");
                }
                int ww=0;
                for(int o=0;o<plastic.size();o++) {
                    if(plastic.get(o).hp>0) {
                        ww++;
                    }
                }
                if(ww==0){
                    ww=1;
                }
                for(int jj=0;jj<p.size();jj++) {
                    if(p.get(jj).character.equals("Mafia")) {
                        p.get(jj).hp=p.get(jj).hp-initial/ww;
                        if(p.get(jj).hp<0){
                            p.get(jj).hp=0;
                        }
                    }

                }
                return x;

            }
            public void usereleminate(ArrayList<player> p,int oop) {
                //	int x=r.nextInt(p.size());
                int z=0;
                plastic=new ArrayList<player>(p.size());
                int initial=p.get(oop).hp;
                for(int d=0;d<p.size();d++) {
                    if(p.get(d).character.equals("Mafia")) {
                        z=z+p.get(d).hp;
                        plastic.add(p.get(d));
                    }

                }
                if(z>=p.get(oop).hp) {
                    p.get(oop).hp=0;

                }
                else {
                    p.get(oop).hp=p.get(oop).hp-z;
                }
                int ww=0;
                for(int o=0;o<plastic.size();o++) {
                    if(plastic.get(o).hp>0) {
                        ww++;
                    }
                }
                if(ww<1) {
                    ww=1;
                }
                for(int jj=0;jj<p.size();jj++) {
                    if(p.get(jj).character.equals("Mafia")) {
                        p.get(jj).hp=p.get(jj).hp-initial/ww;
                    }

                }

            }

        }
        public class detective extends abs{
            private int dhp=800;
            private String drole="Detective";

            @Override
            void assignrandom(ArrayList<player> pl) {
                plastic=new ArrayList<player>(pl.size());
                // TODO Auto-generated method stub
                for(int y=0;y<pl.size()/5;y++) {
                    int a=r.nextInt(pl.size());

                    int members=0;
                    for(int i=0;i<pl.size();i++) {
                        if(pl.get(i).character.equals(drole)){
                            members++;
                        }
                    }
                    int g=pl.size()/5;

                    if(members<g) {

                        if(pl.get(a).hp==0 && pl.get(a).character.equals("t")) {

                            pl.get(a).character=drole;
                            pl.get(a).hp=dhp;
                            pl.get(a).index=a;
                            plastic.add(pl.get(a));

                        }
                        else {
                            y--;
                        }
                    }}

            }

            @Override
            void voting(ArrayList<player> p, int e) {
                int x=r.nextInt(p.size());
                int b= p.get(x).index+1;
                p.remove(x);
                System.out.println("Out voted player"+" "+b);
            }

            @Override
            void ownvoting(ArrayList<player> p) {
                int x=r.nextInt(p.size());
                int b= p.get(x).index+1;
                p.remove(x);
                System.out.println("Out voted player"+" "+b);
            }

            public int owntestchar(ArrayList<player> p,int bang) {
                int hash=0;
                for(int m=0;m<1;m++) {
                    int h=r.nextInt(p.size());
                    if(p.get(h).equals("Detective")) {
                        m--;
                    }
                    else {
                        hash=h;
                    }

                }
                if(p.get(hash).character.equals("Mafia")) {
                   // helper=p.get(hash).index+1;
             //       bang=bang+hash;
                     hash=hash+0;}

            return hash;
            }

          //      else {

            //        return false;
              //  }



            public boolean usertestchar(ArrayList<player> p,int u) {
                //	int h=r.nextInt(p.size());
                if(p.get(u).character.equals("Mafia")) {
                    return true;
                }
                else {
                    return false;
                }

            }
        }
        public class healer extends abs{
            private int hhp=800;
            private String hrole="Healer";
            @Override
            void assignrandom(ArrayList<player> pl) {
                plastic=new ArrayList<player>(pl.size());
                // TODO Auto-generated method stub
                int e=pl.size()/10;
                if(e<1) {
                    e=1;
                }
                for(int i=0;i<e;i++) {
                    int a=r.nextInt(pl.size());
                    int members=0;
                    for(int m=0;m<pl.size();m++) {
                        if(pl.get(m).character.equals(hrole)){
                            members++;
                        }
                    }
                    int g=pl.size()/10;
                    if(g<1) {
                        g=1;
                    }
                    if(members<g) {
                        if(pl.get(a).hp==0 && pl.get(a).character.equals("t")) {

                            pl.get(a).character=hrole;
                            pl.get(a).hp=hhp;
                            pl.get(a).index=a;
                            plastic.add(pl.get(a));

                        }
                        else {
                            i--;
                        }
                    }

                }}

            @Override
            void voting(ArrayList<player> pl, int e) {
                int x=r.nextInt(pl.size());
                int b= pl.get(x).index+1;
                pl.remove(x);
                System.out.println("Out voted player"+" "+b);
            }

            @Override
            void ownvoting(ArrayList<player> p) {
                int x=r.nextInt(p.size());
                int b= p.get(x).index+1;
                p.remove(x);
                System.out.println("Out voted player"+" "+b);
            }

            public void ownhealsome(ArrayList<player> p) {
                int q=r.nextInt(p.size());
                p.get(q).hp=p.get(q).hp+500;
                int cc=p.get(q).index+1;

            }
            public void userhealsome(ArrayList<player> p,int u) {
                //	int q=r.nextInt(p.size());
                p.get(u).hp=p.get(u).hp+500;
            }
        }

        public class commoner extends abs{
            private int chp=1000;
            private String crole="Commoner";
            @Override
            void assignrandom(ArrayList<player> pl) {
                plastic=new ArrayList<player>(pl.size());
                // TODO Auto-generated method stub
                int k=pl.size()/10+2*pl.size()/5;
                if(pl.size()/10<1) {
                    k=k+1;
                }
                for(int b=0;b<pl.size();b++) {
                    //	int a=r.nextInt(pl.size());

                    if(pl.get(b).hp==0 && pl.get(b).character.equals("t")) {

                        pl.get(b).character=crole;
                        pl.get(b).hp=chp;
                        pl.get(b).index=b;
                        plastic.add(pl.get(b));

                    }	}
//			int c=0;
//			int h=0;
//			int d=0;
//			int m=0;
//			for(int z=0;z<pl.size();z++) {
//				if(pl.get(z).character.equals(crole)) {
//					c++;
//				}
//				if(pl.get(z).character.equals("Healer")) {
//					h++;
//				}
//				if(pl.get(z).character.equals("Detective")) {
//					d++;
//				}
//				if(pl.get(z).character.equals("Mafia")) {
//					m++;
//				}
//				int y=c-k;
//				if(pl.size()/5>m && c>y ) {
//					for(int w=0;w<pl.size();w++) {
//						if(pl.get(w).character.equals(crole)) {
//							pl.get(w).character="Mafia";
//							pl.get(w).hp=2500;
//							c--;
//							m++;
//
//
//						}
//						if(m==pl.size()/5) {
//							break;
//						}
//
//					}
//
//				}
//				if(pl.size()/5>d  && c>y) {
//					for(int w=0;w<pl.size();w++) {
//						if(pl.get(w).character.equals(crole)) {
//							pl.get(w).character="Detective";
//							pl.get(w).hp=800;
//							c--;
//							d++;
//
//						}
//						if(d==pl.size()/5) {
//							break;
//						}
//					}
//
//				}
//				if(pl.size()/10>h && pl.size()/10>1) {
//					for(int w=0;w<pl.size();w++) {
//						if(pl.get(w).character.equals(crole)) {
//							pl.get(w).character="Healer";
//							pl.get(w).hp=800;
//							c--;
//							h++;
//
//						}
//						if(h==pl.size()/10) {
//							break;
//						}
//					}
//
//				}
//				else if(pl.size()<1 && 1>h) {
//
//						for(int w=0;w<pl.size();w++) {
//							if(pl.get(w).character.equals(crole)) {
//								pl.get(w).character="Healer";
//								pl.get(w).hp=800;
//								c--;
//								h++;
//
//							}
//							if(h==1) {
//								break;
//							}
//						}
//
//
//
//				}
//
//
//			}
//
            }

            @Override
            void voting(ArrayList<player> pl, int e) {
                int x=r.nextInt(pl.size());
                int b= pl.get(x).index+1;
                pl.remove(x);
                System.out.println("Out voted player"+" "+b);
            }

            @Override
            void ownvoting(ArrayList<player> p) {
                int x=r.nextInt(p.size());
                int b= p.get(x).index+1;
                p.remove(x);
                System.out.println("Out voted player"+" "+b);
            }
        }








        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            mafia ob = new mafia();
            mafiagang maff = ob.new mafiagang();
            detective det = ob.new detective();
            healer heal = ob.new healer();
            commoner com = ob.new commoner();

            System.out.println("Enter number of players");
            int n = sc.nextInt();
            if (n < 6) {
                System.out.println("Minimum 6 players needed");
                System.out.println("Please Enter Again");
                n = sc.nextInt();
            }

            ArrayList<player> pl = new ArrayList<player>(n);
            ArrayList<player> prinpl=new ArrayList<player>(n);
            for (int x = 0; x < n; x++) {
                player p = ob.new player();
                p.hp = 0;
                p.character = "t";
                pl.add(p);
                prinpl.add(p);
            }
            System.out.println("Select Your Character");
            System.out.println("1) Mafia");
            System.out.println("2) Detective");
            System.out.println("3) Healer");
            System.out.println("4) Commoner");
            System.out.println("5) Assign Random");
            int inp = sc.nextInt();
            if (inp == 1) {
                pl.get(0).character = "Mafia";
                pl.get(0).hp = 2500;
                maff.assignrandom(pl);
                det.assignrandom(pl);
                heal.assignrandom(pl);
                com.assignrandom(pl);
                for (int i = 0; i < n; i++) {
                    prinpl.get(i).character=pl.get(i).character;
                    prinpl.get(i).index=pl.get(i).index;
                    prinpl.get(i).hp=pl.get(i).hp;
                }
                for (int i = 0; i < 1000; i++) {

                    int jk = i + 1;
                    int help = 0;
                    int cm = 0;
                    int bang = 0;
                    System.out.println("Round" + " " + jk);
                    System.out.println("Alive players:");
                    int jojo = 0;
                    for (int raw = 0; raw < pl.size(); raw++) {
                        int xy = pl.get(raw).index + 1;
                        System.out.print("player" + xy + ",");
                        if (xy == 1) {
                            jojo++;
                        }
                    }


                    if (jojo == 1) {
                        System.out.println("\nChoose a target");
                        for (int in = 0; in < 1; in++) {
                            int b = sc.nextInt();
                            b = b - 1;
                            int he = 0;
                            for (int ji = 0; ji < pl.size(); ji++) {
                                if (pl.get(ji).index == b) {
                                    he = ji;
                                    break;
                                }
                            }
//				b=b-1;
                            if (pl.get(he).character.equals("Mafia")) {
                                in--;
                            } else {
                                help = he;
                            }
                        }

                        maff.usereleminate(pl, help);
                    } else if (jojo == 0 && maff.plastic.size() > 0) {
                        System.out.println("\nMafias have chosen their target");
                        cm = maff.owneleminate(pl);
                    }
                    int tt = 0;
                    for (int op = 0; op < pl.size(); op++) {
                        if (pl.get(op).character.equals("Detective")) {
                            tt++;
                        }
                    }

                    int cx = 0;
                    if (tt > 0) {
                        System.out.println("Detectives have chosen someone to test");

                        cx = det.owntestchar(pl, bang);
                    }
                    int heels = 0;
                    for (int hh = 0; hh < pl.size(); hh++) {
                        if (pl.get(hh).character.equals("Healer")) {
                            heels++;
                        }
                    }
                    if (heels > 0) {
                        System.out.println("Healers have chosen someone to heal");
                        heal.ownhealsome(pl);
                    }
                    if (pl.get(help).hp == 0 && jojo == 1) {
                        int uu = pl.get(help).index + 1;
                        pl.remove(help);

                        System.out.println("Player" + " " + uu + " " + "died");
                    } else if (pl.get(help).hp > 0 && jojo == 1) {
                        int bx = pl.get(help).index + 1;
                        System.out.println("Player" + " " + bx + " " + "is alive");
                    } else if (pl.get(cm).hp == 0 && jojo == 0) {
                        int f = pl.get(cm).index + 1;
                        pl.remove(cm);
                        System.out.println("Player" + " " + f + " " + "died");
                    } else if (pl.get(cm).hp > 0 && jojo == 0) {
                        int uu = pl.get(cm).index + 1;
                        System.out.println("Player" + " " + uu + " " + "is alive");
                    }
                    int yy = 0;
                    for (int op = 0; op < pl.size(); op++) {
                        if (pl.get(op).character.equals("Detective")) {
                            yy++;
                        }
                    }
                    if (yy > 0) {
                        if (pl.get(cx).character.equals("Mafia")) {
                            int bb = pl.get(bang).index + 1;
                            pl.remove(bang);
                            System.out.println("Player" + " " + bb + " " + "has been voted out");

                        } else {
                            if (jojo == 1) {
                                System.out.println("Select a person to vote out");
                                int ee = sc.nextInt();
                                maff.voting(pl, ee);
                            } else if (jojo == 0) {
                                maff.ownvoting(pl);
                            }
                        }
                    } else {
                        if (jojo == 1) {
                            System.out.println("Select a person to vote out");
                            int ee = sc.nextInt();
                            maff.voting(pl, ee);
                        } else if (jojo == 0) {
                            maff.ownvoting(pl);
                        }

                    }

                    if (maff.plastic.size() == (pl.size() - maff.plastic.size()) && maff.plastic.size() != 0 && pl.size() != 0) {
                        System.out.println("Mafia won");
                        for(int r=0;r<prinpl.size();r++){
                            int hrt=prinpl.get(r).index+1;
                            System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                        break;
                    }
                    if (maff.plastic.size() == 0) {
                        System.out.println("Mafias are being eliminated");
                        for(int r=0;r<prinpl.size();r++){
                            int hrt=prinpl.get(r).index+1;
                            System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                        break;
                    }


                }
            }
            if (inp == 2) {
                pl.get(0).character = "Detective";
                pl.get(0).hp = 800;
                maff.assignrandom(pl);
                det.assignrandom(pl);
                heal.assignrandom(pl);
                com.assignrandom(pl);
                for (int i = 0; i < n; i++) {
                    prinpl.get(i).character=pl.get(i).character;
                    prinpl.get(i).index=pl.get(i).index;
                    prinpl.get(i).hp=pl.get(i).hp;
                }
                System.out.println("Other Detectives are:");
                for (int i = 1; i < pl.size(); i++) {
                    if (pl.get(i).character.equals("Detective")) {
                        int c = pl.get(i).index + 1;
                        System.out.print("player" + c + ",");
                    }
                }
                for (int b = 0; b < 1000; b++) {
                    boolean bold = true;
                    int jk = b + 1;
                    int help = 0;

                    int cm = 0;
                    int uui = 0;
                    int bang = 0;
                    int oper = 0;
                    int autocmind = 0;
                    int B = 0;
                    System.out.println("Round" + " " + jk);
                    System.out.println("Alive players:");
                    int jojo = 0;
                    for (int raw = 0; raw < pl.size(); raw++) {
                        int xy = pl.get(raw).index + 1;
                        System.out.print("player" + xy + ",");
                        if (xy == 1) {
                            jojo++;
                        }
                    }
                    // int tt = 0;
                    // for (int op = 0; op < pl.size(); op++) {
                    //   if (pl.get(op).character.equals("Mafia")) {
                    //        tt++;
                    //      }
                    //  }
                    //    if (tt > 0) {
                    System.out.println("Mafias have chosen their target");

                    uui = maff.owneleminate(pl);
                    //      }
                    //   System.out.println(uui);
                    //     System.out.println("Choose the person to test");
                    if (jojo == 1) {
                        System.out.println("\nChoose the person to test");
                        for (int in = 0; in < 1; in++) {
                            B = sc.nextInt();
                            B = B - 1;
                            int he = 0;
                            for (int ji = 0; ji < pl.size(); ji++) {
                                if (pl.get(ji).index == B) {
                                    he = ji;
                                    break;
                                }
                            }
//				b=b-1;
                            if (pl.get(he).character.equals("Detective")) {
                                System.out.println("Cannot test another detective");
                                in--;
                            } else {
                                help = he;
                            }
                        }
                        int inc = 0;
                        bold = det.usertestchar(pl, help);
                        if (bold == true && pl.get(help).character.equals("Mafia")) {
                            int bx = pl.get(help).index + 1;
                            System.out.println("player" + " " + bx + " " + "is mafia");
                            inc++;
                        } else {
                            int bx = pl.get(help).index + 1;
                            System.out.println("player" + " " + bx + " " + "is not mafia");
                        }
                    } else if (jojo == 0 && det.plastic.size() > 0) {
                        System.out.println("\nDetectives have chosen the person to test");
                        cm = det.owntestchar(pl, bang);
                        autocmind = pl.get(cm).index;
                    }
                    int hi = 0;
                    for (int op = 0; op < pl.size(); op++) {
                        if (pl.get(op).character.equals("Healer")) {
                            hi++;
                        }
                    }
                    if (hi > 0) {
                        System.out.println("Healers have chosen someone to heal");
                        heal.ownhealsome(pl);
                    }
                    if (pl.get(uui).hp == 0) {
                        int f = pl.get(uui).index + 1;
                        pl.remove(uui);
                        oper++;
                        System.out.println("Player" + " " + f + " " + "died");
                    } else if (pl.get(uui).hp > 0) {
                        int uu = pl.get(uui).index + 1;
                        System.out.println("Player" + " " + uu + " " + "is alive");
                    }

                    int yy = 0;
                    for (int op = 0; op < pl.size(); op++) {
                        if (pl.get(op).character.equals("Detective")) {
                            yy++;
                        }
                    }
                    if (oper == 1) {
                        help--;
                        cm--;

                    }
                    if (yy > 0) {

                        if (jojo == 1) {
                            int open = 0;
                            for (int yw = 0; yw < pl.size(); yw++) {
                                if (pl.get(yw).index == B) {
                                    open = yw;
                                    break;
                                }
                            }

                            if (bold == true && pl.get(open).character.equals("Mafia")) {
                                int bb = pl.get(open).index + 1;
                                maff.plastic.remove(0);
                                pl.remove(open);
                                System.out.println("Player" + " " + bb + " " + "has been voted out");
                            } else {
                                System.out.println("Choose someone to vote");
                                int yep = sc.nextInt();
                                det.voting(pl, yep);

                            }


                        } else if (jojo == 0) {

//                           if(cm==pl.size()){
//                               cm--;
//                           }
                            int free = 0;
                            for (int yest = 0; yest < pl.size(); yest++) {
                                if (pl.get(yest).index == autocmind) {
                                    free = yest;
                                }
                            }

                            if (pl.get(free).character.equals("Mafia")) {
                                int bb = pl.get(free).index + 1;
                                pl.remove(free);
                                maff.plastic.remove(free);
                                System.out.println("Player" + " " + bb + " " + "has been voted out");


                            } else {
                                det.ownvoting(pl);
                            }
                        }
                    }


                    //   int tes=sc.nextInt();
                    //  det.usertestchar(pl,tes);


                    if (maff.plastic.size() == (pl.size() - maff.plastic.size()) && maff.plastic.size() != 0 && pl.size() != 0) {
                        System.out.println("Mafia won");
                        for(int r=0;r<prinpl.size();r++){
                            int hrt=prinpl.get(r).index+1;
                            System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                        break;
                    }
                    if (maff.plastic.size() == 0) {
                        System.out.println("Mafias are being eliminated");
                        for(int r=0;r<prinpl.size();r++){
                            int hrt=prinpl.get(r).index+1;
                            System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                        break;
                    }

                }
            }
            if (inp == 3) {
                pl.get(0).character = "Healer";
                pl.get(0).hp = 800;
                maff.assignrandom(pl);
                det.assignrandom(pl);
                heal.assignrandom(pl);
                com.assignrandom(pl);
                for (int i = 0; i < n; i++) {
                    prinpl.get(i).character=pl.get(i).character;
                    prinpl.get(i).index=pl.get(i).index;
                    prinpl.get(i).hp=pl.get(i).hp;
                }

                for (int b = 0; b < 1000; b++) {
                    boolean bold = true;
                    int jk = b + 1;
                    int help = 0;
                    int cm = 0;
                    int chindex = 0;
                    int uui = 0;
                    int bang = 0;
                    int oper = 0;
                    int autocmind = 0;
                    int B = 0;
                    System.out.println("Round" + " " + jk);
                    System.out.println("Alive players:");
                    int jojo = 0;
                    for (int raw = 0; raw < pl.size(); raw++) {
                        int xy = pl.get(raw).index + 1;
                        System.out.print("player" + xy + ",");
                        if (xy == 1) {
                            jojo++;
                        }
                    }
//                    int tt = 0;
//                    for (int op = 0; op < pl.size(); op++) {
//                        if (pl.get(op).character.equals("Detective")) {
//                            tt++;
//                        }
//                    }

                    System.out.println("Mafias have chosen their target");
                    uui = maff.owneleminate(pl);
                  //  if(tt>0){
                    System.out.println("Detectives have chosen someone to test");
                    cm = det.owntestchar(pl, bang);
                    chindex = pl.get(cm).index;
                 //   }

                    if (jojo == 1) {
                        System.out.println("\nChoose someone to heal");
                        for (int in = 0; in < 1; in++) {
                            B = sc.nextInt();
                            B = B - 1;
                            int he = 0;
                            for (int ji = 0; ji < pl.size(); ji++) {
                                if (pl.get(ji).index == B) {
                                    he = ji;
                                    break;
                                }
                            }
//				b=b-1;
//                                if (pl.get(he).character.equals("Detective")) {
//                                    System.out.println("Cannot test another detective");
//                                    in--;
//                                } else {
//                                    help = he;
//                                }
                            //  help = he;
                            int hr = 0;
                            for (int hy = 0; hy < pl.size(); hy++) {
                                if (pl.get(hy).index == pl.get(he).index) {
                                    hr++;
                                }
                            }
                            if (hr == 0) {
                                System.out.println("Cannot choose this player");
                                in--;
                            } else {
                                help = he;
                            }


                        }
//                            int inc=0;
//                            bold = det.usertestchar(pl, help);
//                            if(bold==true && pl.get(help).character.equals("Mafia")){
//                                int bx=pl.get(help).index+1;
//                                System.out.println("player"+" "+ bx+" "+"is mafia");
//                                inc++;
//                            }
//                            else{
//                                int bx=pl.get(help).index+1;
//                                System.out.println("player"+" "+ bx+" "+"is not mafia");
//                            }
                        heal.userhealsome(pl, help);


                    } else if (jojo == 0 && heal.plastic.size() > 0) {
                        System.out.println("\nHealers have chosen to heal someone");
                        heal.ownhealsome(pl);
                    }

                    if (pl.get(uui).hp == 0) {
                        int f = pl.get(uui).index + 1;
                        pl.remove(uui);
                        oper++;
                        System.out.println("Player" + " " + f + " " + "died");
                    } else if (pl.get(uui).hp > 0) {
                        int uu = pl.get(uui).index + 1;
                        System.out.println("No one died");
                    }

                    int yy = 0;
                    for (int op = 0; op < pl.size(); op++) {
                        if (pl.get(op).character.equals("Detective")) {
                            yy++;
                        }
                    }

                    if (yy > 0) {
                        int free = 0;
                        for (int yest = 0; yest < pl.size(); yest++) {
                            if (pl.get(yest).index == chindex) {
                                free = yest;
                            }
                        }

                        if (pl.get(free).character.equals("Mafia")) {
                            int bb = pl.get(free).index + 1;
                            pl.remove(free);
                            maff.plastic.remove(0);
                            System.out.println("Player" + " " + bb + " " + "has been voted out");


                        } else {
                            if (jojo == 1) {
                                System.out.println("Select a person to vote out");
                                int ee = sc.nextInt();
                                heal.voting(pl, ee);
                            } else if (jojo == 0) {
                                heal.ownvoting(pl);
                            }
                        }
                    } else {
                        if (jojo == 1) {
                            System.out.println("Select a person to vote out");
                            int ee = sc.nextInt();
                            heal.voting(pl, ee);
                        } else if (jojo == 0) {
                            heal.ownvoting(pl);
                        }

                    }

                    if (maff.plastic.size() == (pl.size() - maff.plastic.size()) && maff.plastic.size() != 0 && pl.size() != 0) {
                        System.out.println("Mafia won");
                        for(int r=0;r<prinpl.size();r++){
                            int hrt=prinpl.get(r).index+1;
                            System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                        break;

                    }
                    if (maff.plastic.size() == 0) {
                        System.out.println("Mafias are being eliminated");
                        for(int r=0;r<prinpl.size();r++){
                            int hrt=prinpl.get(r).index+1;
                            System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                        break;
                    }

                }


            }


            if (inp == 4) {
                pl.get(0).character = "Commoner";
                pl.get(0).hp = 1000;
                maff.assignrandom(pl);
                det.assignrandom(pl);
                heal.assignrandom(pl);
                com.assignrandom(pl);
                for (int i = 0; i < n; i++) {
                    prinpl.get(i).character=pl.get(i).character;
                    prinpl.get(i).index=pl.get(i).index;
                    prinpl.get(i).hp=pl.get(i).hp;
                }

                for (int b = 0; b < 1000; b++) {
                    boolean bold = true;
                    int jk = b + 1;
                    int help = 0;
                    int cm = 0;
                    int chindex = 0;
                    int uui = 0;
                    int bang = 0;
                    int oper = 0;
                    int autocmind = 0;
                    int B = 0;
                    System.out.println("Round" + " " + jk);
                    System.out.println("Alive players:");
                    int jojo = 0;
                    for (int raw = 0; raw < pl.size(); raw++) {
                        int xy = pl.get(raw).index + 1;
                        System.out.print("player" + xy + ",");
                        if (xy == 1) {
                            jojo++;
                        }
                    }
                    int tt = 0;
                    for (int op = 0; op < pl.size(); op++) {
                        if (pl.get(op).character.equals("Detective")) {
                            tt++;
                        }
                    }
                    System.out.println("Mafias have chosen their target");
                    uui = maff.owneleminate(pl);
                    if(tt>0){
                    System.out.println("Detectives have chosen someone to test");
                    cm = det.owntestchar(pl, bang);
                    chindex = pl.get(cm).index;}
                    int huh=0;
                    for (int op = 0; op < pl.size(); op++) {
                        if (pl.get(op).character.equals("Detective")) {
                            huh++;
                        }
                    }
                    if(huh>0){
                    System.out.println("Healers have chosen someone to heal");
                    heal.ownhealsome(pl);}
                    if (pl.get(uui).hp == 0) {
                        int f = pl.get(uui).index + 1;
                        pl.remove(uui);
                        oper++;
                        System.out.println("Player" + " " + f + " " + "died");
                    } else if (pl.get(uui).hp > 0) {
                        int uu = pl.get(uui).index + 1;
                        System.out.println("No one died");
                    }

                    int yy = 0;
                    for (int op = 0; op < pl.size(); op++) {
                        if (pl.get(op).character.equals("Detective")) {
                            yy++;
                        }
                    }

                    if (yy > 0) {
                        int free = 0;
                        for (int yest = 0; yest < pl.size(); yest++) {
                            if (pl.get(yest).index == chindex) {
                                free = yest;
                            }
                        }

                        if (pl.get(free).character.equals("Mafia")) {
                            int bb = pl.get(free).index + 1;
                            pl.remove(free);
                            maff.plastic.remove(0);
                            System.out.println("Player" + " " + bb + " " + "has been voted out");


                        } else {


                            if (jojo == 1) {
                                System.out.println("Choose someone to vote");
                                for (int in = 0; in < 1; in++) {
                                    B = sc.nextInt();
                                    B = B - 1;
                                    int he = 0;
                                    for (int ji = 0; ji < pl.size(); ji++) {
                                        if (pl.get(ji).index == B) {
                                            he = ji;
                                            break;
                                        }
                                    }
//				b=b-1;
//                                if (pl.get(he).character.equals("Detective")) {
//                                    System.out.println("Cannot test another detective");
//                                    in--;
//                                } else {
//                                    help = he;
//                                }
                                    //  help = he;
                                    int hr = 0;
                                    for (int hy = 0; hy < pl.size(); hy++) {
                                        if (pl.get(hy).index == pl.get(he).index) {
                                            hr++;
                                        }
                                    }
                                    if (hr < 1) {
                                        System.out.println("Cannot choose this player");
                                        in--;
                                    } else {
                                        help = he;
                                    }


                                }
                                com.voting(pl, help);

                            } else if (jojo == 0 && com.plastic.size() > 0) {
                                System.out.println("\nCommuners will vote someone");
                                com.ownvoting(pl);
                            }
                        }


                    }
                    else {


                        if (jojo == 1) {
                            System.out.println("Choose someone to vote");
                            for (int in = 0; in < 1; in++) {
                                B = sc.nextInt();
                                B = B - 1;
                                int he = 0;
                                for (int ji = 0; ji < pl.size(); ji++) {
                                    if (pl.get(ji).index == B) {
                                        he = ji;
                                        break;
                                    }
                                }
//				b=b-1;
//                                if (pl.get(he).character.equals("Detective")) {
//                                    System.out.println("Cannot test another detective");
//                                    in--;
//                                } else {
//                                    help = he;
//                                }
                                //  help = he;
                                int hr = 0;
                                for (int hy = 0; hy < pl.size(); hy++) {
                                    if (pl.get(hy).index == pl.get(he).index) {
                                        hr++;
                                    }
                                }
                                if (hr < 1) {
                                    System.out.println("Cannot choose this player");
                                    in--;
                                } else {
                                    help = he;
                                }


                            }
                            com.voting(pl, help);

                        } else if (jojo == 0 && com.plastic.size() > 0) {
                            System.out.println("\nCommuners will vote someone");
                            com.ownvoting(pl);
                        }
                    }
                    if (maff.plastic.size() == (pl.size() - maff.plastic.size()) && maff.plastic.size() != 0 && pl.size() != 0) {
                        System.out.println("Mafia won");
                        for(int r=0;r<prinpl.size();r++){
                            int hrt=prinpl.get(r).index+1;
                            System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                        break;
                    }
                    if (maff.plastic.size() == 0) {
                        System.out.println("Mafias are being eliminated");
                        for(int r=0;r<prinpl.size();r++){
                            int hrt=prinpl.get(r).index+1;
                            System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                        break;
                    }


                }



                }
                if (inp == 5) {
                    maff.assignrandom(pl);
                    det.assignrandom(pl);
                    heal.assignrandom(pl);
                    com.assignrandom(pl);
                    for (int i = 0; i < n; i++) {
                        prinpl.get(i).character=pl.get(i).character;
                        prinpl.get(i).index=pl.get(i).index;
                        prinpl.get(i).hp=pl.get(i).hp;
                    }
                    if(pl.get(0).character.equals("Mafia")){
                        for (int i = 0; i < 1000; i++) {

                            int jk = i + 1;
                            int help = 0;
                            int cm = 0;
                            int bang = 0;
                            System.out.println("Round" + " " + jk);
                            System.out.println("Alive players:");
                            int jojo = 0;
                            for (int raw = 0; raw < pl.size(); raw++) {
                                int xy = pl.get(raw).index + 1;
                                System.out.print("player" + xy + ",");
                                if (xy == 1) {
                                    jojo++;
                                }
                            }


                            if (jojo == 1) {
                                System.out.println("\nChoose a target");
                                for (int in = 0; in < 1; in++) {
                                    int b = sc.nextInt();
                                    b = b - 1;
                                    int he = 0;
                                    for (int ji = 0; ji < pl.size(); ji++) {
                                        if (pl.get(ji).index == b) {
                                            he = ji;
                                            break;
                                        }
                                    }
//				b=b-1;
                                    if (pl.get(he).character.equals("Mafia")) {
                                        in--;
                                    } else {
                                        help = he;
                                    }
                                }

                                maff.usereleminate(pl, help);
                            } else if (jojo == 0 && maff.plastic.size() > 0) {
                                System.out.println("\nMafias have chosen their target");
                                cm = maff.owneleminate(pl);
                            }
                            int tt = 0;
                            for (int op = 0; op < pl.size(); op++) {
                                if (pl.get(op).character.equals("Detective")) {
                                    tt++;
                                }
                            }

                            int cx = 0;

                                System.out.println("Detectives have chosen someone to test");
                            if (tt > 0) {
                                cx = det.owntestchar(pl, bang);
                            }
                            int heels = 0;
                            for (int hh = 0; hh < pl.size(); hh++) {
                                if (pl.get(hh).character.equals("Healer")) {
                                    heels++;
                                }
                            }
                            System.out.println("Healers have chosen someone to heal");
                            if (heels > 0) {
                                heal.ownhealsome(pl);
                            }
                            if (pl.get(help).hp == 0 && jojo == 1) {
                                int uu = pl.get(help).index + 1;
                                pl.remove(help);

                                System.out.println("Player" + " " + uu + " " + "died");
                            } else if (pl.get(help).hp > 0 && jojo == 1) {
                                int bx = pl.get(help).index + 1;
                                System.out.println("No one died");
                            } else if (pl.get(cm).hp == 0 && jojo == 0) {
                                int f = pl.get(cm).index + 1;
                                pl.remove(cm);
                                System.out.println("Player" + " " + f + " " + "died");
                            } else if (pl.get(cm).hp > 0 && jojo == 0) {
                                int uu = pl.get(cm).index + 1;
                                System.out.println("No one died");
                            }
                            int yy = 0;
                            for (int op = 0; op < pl.size(); op++) {
                                if (pl.get(op).character.equals("Detective")) {
                                    yy++;
                                }
                            }
                            if (yy > 0) {
                                if (pl.get(cx).character.equals("Mafia")) {
                                    int bb = pl.get(bang).index + 1;
                                    pl.remove(bang);
                                    System.out.println("Player" + " " + bb + " " + "has been voted out");

                                } else {
                                    if (jojo == 1) {
                                        System.out.println("Select a person to vote out");
                                        int ee = sc.nextInt();
                                        maff.voting(pl, ee);
                                    } else if (jojo == 0) {
                                        maff.ownvoting(pl);
                                    }
                                }
                            } else {
                                if (jojo == 1) {
                                    System.out.println("Select a person to vote out");
                                    int ee = sc.nextInt();
                                    maff.voting(pl, ee);
                                } else if (jojo == 0) {
                                    maff.ownvoting(pl);
                                }

                            }

                            if (maff.plastic.size() == (pl.size() - maff.plastic.size()) && maff.plastic.size() != 0 && pl.size() != 0) {
                                System.out.println("Mafia won");
                                for(int r=0;r<prinpl.size();r++){
                                    int hrt=prinpl.get(r).index+1;
                                    System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                                System.exit(0);
                                break;
                            }
                            if (maff.plastic.size() == 0) {
                                System.out.println("Mafias are being eliminated");
                                for(int r=0;r<prinpl.size();r++){
                                    int hrt=prinpl.get(r).index+1;
                                    System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                                System.exit(0);
                                break;
                            }


                        }

                    }

                    if(pl.get(0).character.equals("Detective")){
                        System.out.println("Other Detectives are:");
                        for (int i = 1; i < pl.size(); i++) {
                            if (pl.get(i).character.equals("Detective")) {
                                int c = pl.get(i).index + 1;
                                System.out.print("player" + c + ",");
                            }
                        }
                        for (int b = 0; b < 1000; b++) {
                            boolean bold = true;
                            int jk = b + 1;
                            int help = 0;

                            int cm = 0;
                            int uui = 0;
                            int bang = 0;
                            int oper = 0;
                            int autocmind = 0;
                            int B = 0;
                            System.out.println("Round" + " " + jk);
                            System.out.println("Alive players:");
                            int jojo = 0;
                            for (int raw = 0; raw < pl.size(); raw++) {
                                int xy = pl.get(raw).index + 1;
                                System.out.print("player" + xy + ",");
                                if (xy == 1) {
                                    jojo++;
                                }
                            }
                            // int tt = 0;
                            // for (int op = 0; op < pl.size(); op++) {
                            //   if (pl.get(op).character.equals("Mafia")) {
                            //        tt++;
                            //      }
                            //  }
                            //    if (tt > 0) {
                            System.out.println("Mafias have chosen their target");

                            uui = maff.owneleminate(pl);
                            //      }
                            //   System.out.println(uui);
                            //     System.out.println("Choose the person to test");
                            if (jojo == 1) {
                                System.out.println("\nChoose the person to test");
                                for (int in = 0; in < 1; in++) {
                                    B = sc.nextInt();
                                    B = B - 1;
                                    int he = 0;
                                    for (int ji = 0; ji < pl.size(); ji++) {
                                        if (pl.get(ji).index == B) {
                                            he = ji;
                                            break;
                                        }
                                    }
//				b=b-1;
                                    if (pl.get(he).character.equals("Detective")) {
                                        System.out.println("Cannot test another detective");
                                        in--;
                                    } else {
                                        help = he;
                                    }
                                }
                                int inc = 0;
                                bold = det.usertestchar(pl, help);
                                if (bold == true && pl.get(help).character.equals("Mafia")) {
                                    int bx = pl.get(help).index + 1;
                                    System.out.println("player" + " " + bx + " " + "is mafia");
                                    inc++;
                                } else {
                                    int bx = pl.get(help).index + 1;
                                    System.out.println("player" + " " + bx + " " + "is not mafia");
                                }
                            } else if (jojo == 0 && det.plastic.size() > 0) {
                                System.out.println("\nDetectives have chosen the person to test");
                                cm = det.owntestchar(pl, bang);
                                autocmind = pl.get(cm).index;
                            }
                            int hi = 0;
                            for (int op = 0; op < pl.size(); op++) {
                                if (pl.get(op).character.equals("Healer")) {
                                    hi++;
                                }
                            }
                            System.out.println("Healers have chosen someone to heal");
                            if (hi > 0) {
                                heal.ownhealsome(pl);
                            }
                            if (pl.get(uui).hp == 0) {
                                int f = pl.get(uui).index + 1;
                                pl.remove(uui);
                                oper++;
                                System.out.println("Player" + " " + f + " " + "died");
                            } else if (pl.get(uui).hp > 0) {
                                int uu = pl.get(uui).index + 1;
                                System.out.println("No ome died");
                            }

                            int yy = 0;
                            for (int op = 0; op < pl.size(); op++) {
                                if (pl.get(op).character.equals("Detective")) {
                                    yy++;
                                }
                            }
                            if (oper == 1) {
                                help--;
                                cm--;

                            }
                            if (yy > 0) {

                                if (jojo == 1) {
                                    int open = 0;
                                    for (int yw = 0; yw < pl.size(); yw++) {
                                        if (pl.get(yw).index == B) {
                                            open = yw;
                                            break;
                                        }
                                    }

                                    if (bold == true && pl.get(open).character.equals("Mafia")) {
                                        int bb = pl.get(open).index + 1;
                                        maff.plastic.remove(0);
                                        pl.remove(open);
                                        System.out.println("Player" + " " + bb + " " + "has been voted out");
                                    } else {
                                        System.out.println("Choose someone to vote");
                                        int yep = sc.nextInt();
                                        det.voting(pl, yep);

                                    }


                                } else if (jojo == 0) {

//                           if(cm==pl.size()){
//                               cm--;
//                           }
                                    int free = 0;
                                    for (int yest = 0; yest < pl.size(); yest++) {
                                        if (pl.get(yest).index == autocmind) {
                                            free = yest;
                                        }
                                    }

                                    if (pl.get(free).character.equals("Mafia")) {
                                        int bb = pl.get(free).index + 1;
                                        pl.remove(free);
                                        maff.plastic.remove(free);
                                        System.out.println("Player" + " " + bb + " " + "has been voted out");


                                    } else {
                                        det.ownvoting(pl);
                                    }
                                }
                            }


                            //   int tes=sc.nextInt();
                            //  det.usertestchar(pl,tes);


                            if (maff.plastic.size() == (pl.size() - maff.plastic.size()) && maff.plastic.size() != 0 && pl.size() != 0) {
                                System.out.println("Mafia won");
                                for(int r=0;r<prinpl.size();r++){
                                    int hrt=prinpl.get(r).index+1;
                                    System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                                break;
                            }
                            if (maff.plastic.size() == 0) {
                                System.out.println("Mafias are being eliminated");
                                for(int r=0;r<prinpl.size();r++){
                                    int hrt=prinpl.get(r).index+1;
                                    System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                                System.exit(0);
                                break;
                            }

                        }


                    }
                    else if(pl.get(0).character.equals("Healer")){

                        for (int b = 0; b < 1000; b++) {
                            boolean bold = true;
                            int jk = b + 1;
                            int help = 0;
                            int cm = 0;
                            int chindex = 0;
                            int uui = 0;
                            int bang = 0;
                            int oper = 0;
                            int autocmind = 0;
                            int B = 0;
                            System.out.println("Round" + " " + jk);
                            System.out.println("Alive players:");
                            int jojo = 0;
                            for (int raw = 0; raw < pl.size(); raw++) {
                                int xy = pl.get(raw).index + 1;
                                System.out.print("player" + xy + ",");
                                if (xy == 1) {
                                    jojo++;
                                }
                            }
                    int tt = 0;
                    for (int op = 0; op < pl.size(); op++) {
                        if (pl.get(op).character.equals("Detective")) {
                            tt++;
                        }
                    }

                            System.out.println("Mafias have chosen their target");
                            uui = maff.owneleminate(pl);
                            System.out.println("Detectives have chosen someone to test");
                              if(tt>0){

                            cm = det.owntestchar(pl, bang);
                            chindex = pl.get(cm).index;
                               }

                            if (jojo == 1) {
                                System.out.println("\nChoose someone to heal");
                                for (int in = 0; in < 1; in++) {
                                    B = sc.nextInt();
                                    B = B - 1;
                                    int he = 0;
                                    for (int ji = 0; ji < pl.size(); ji++) {
                                        if (pl.get(ji).index == B) {
                                            he = ji;
                                            break;
                                        }
                                    }
//				b=b-1;
//                                if (pl.get(he).character.equals("Detective")) {
//                                    System.out.println("Cannot test another detective");
//                                    in--;
//                                } else {
//                                    help = he;
//                                }
                                    //  help = he;
                                    int hr = 0;
                                    for (int hy = 0; hy < pl.size(); hy++) {
                                        if (pl.get(hy).index == pl.get(he).index) {
                                            hr++;
                                        }
                                    }
                                    if (hr == 0) {
                                        System.out.println("Cannot choose this player");
                                        in--;
                                    } else {
                                        help = he;
                                    }


                                }
//                            int inc=0;
//                            bold = det.usertestchar(pl, help);
//                            if(bold==true && pl.get(help).character.equals("Mafia")){
//                                int bx=pl.get(help).index+1;
//                                System.out.println("player"+" "+ bx+" "+"is mafia");
//                                inc++;
//                            }
//                            else{
//                                int bx=pl.get(help).index+1;
//                                System.out.println("player"+" "+ bx+" "+"is not mafia");
//                            }
                                heal.userhealsome(pl, help);


                            } else if (jojo == 0 && heal.plastic.size() > 0) {
                                System.out.println("\nHealers have chosen to heal someone");
                                heal.ownhealsome(pl);
                            }

                            if (pl.get(uui).hp == 0) {
                                int f = pl.get(uui).index + 1;
                                pl.remove(uui);
                                oper++;
                                System.out.println("Player" + " " + f + " " + "died");
                            } else if (pl.get(uui).hp > 0) {
                                int uu = pl.get(uui).index + 1;
                                System.out.println("No one died");
                            }

                            int yy = 0;
                            for (int op = 0; op < pl.size(); op++) {
                                if (pl.get(op).character.equals("Detective")) {
                                    yy++;
                                }
                            }

                            if (yy > 0) {
                                int free = 0;
                                for (int yest = 0; yest < pl.size(); yest++) {
                                    if (pl.get(yest).index == chindex) {
                                        free = yest;
                                    }
                                }

                                if (pl.get(free).character.equals("Mafia")) {
                                    int bb = pl.get(free).index + 1;
                                    pl.remove(free);
                                    maff.plastic.remove(0);
                                    System.out.println("Player" + " " + bb + " " + "has been voted out");


                                } else {
                                    if (jojo == 1) {
                                        System.out.println("Select a person to vote out");
                                        int ee = sc.nextInt();
                                        heal.voting(pl, ee);
                                    } else if (jojo == 0) {
                                        heal.ownvoting(pl);
                                    }
                                }
                            } else {
                                if (jojo == 1) {
                                    System.out.println("Select a person to vote out");
                                    int ee = sc.nextInt();
                                    heal.voting(pl, ee);
                                } else if (jojo == 0) {
                                    heal.ownvoting(pl);
                                }

                            }

                            if (maff.plastic.size() == (pl.size() - maff.plastic.size()) && maff.plastic.size() != 0 && pl.size() != 0) {
                                System.out.println("Mafia won");
                                for(int r=0;r<prinpl.size();r++){
                                    int hrt=prinpl.get(r).index+1;
                                    System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                                System.exit(0);
                                break;

                            }
                            if (maff.plastic.size() == 0) {
                                System.out.println("Mafias are being eliminated");
                                for(int r=0;r<prinpl.size();r++){
                                    int hrt=prinpl.get(r).index+1;
                                    System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                                System.exit(0);
                                break;
                            }

                        }


                    }
                    else if(pl.get(0).character.equals("Commoner")){

                        for (int b = 0; b < 1000; b++) {
                            boolean bold = true;
                            int jk = b + 1;
                            int help = 0;
                            int cm = 0;
                            int chindex = 0;
                            int uui = 0;
                            int bang = 0;
                            int oper = 0;
                            int autocmind = 0;
                            int B = 0;
                            System.out.println("Round" + " " + jk);
                            System.out.println("Alive players:");
                            int jojo = 0;
                            for (int raw = 0; raw < pl.size(); raw++) {
                                int xy = pl.get(raw).index + 1;
                                System.out.print("player" + xy + ",");
                                if (xy == 1) {
                                    jojo++;
                                }
                            }
                            int tt = 0;
                            for (int op = 0; op < pl.size(); op++) {
                                if (pl.get(op).character.equals("Detective")) {
                                    tt++;
                                }
                            }
                            System.out.println("Mafias have chosen their target");
                            uui = maff.owneleminate(pl);
                            if(tt>0){
                                System.out.println("Detectives have chosen someone to test");
                                cm = det.owntestchar(pl, bang);
                                chindex = pl.get(cm).index;}
                            int huh=0;
                            for (int op = 0; op < pl.size(); op++) {
                                if (pl.get(op).character.equals("Detective")) {
                                    huh++;
                                }
                            }
                            if(huh>0){
                                System.out.println("Healers have chosen someone to heal");
                                heal.ownhealsome(pl);}
                            if (pl.get(uui).hp == 0) {
                                int f = pl.get(uui).index + 1;
                                pl.remove(uui);
                                oper++;
                                System.out.println("Player" + " " + f + " " + "died");
                            } else if (pl.get(uui).hp > 0) {
                                int uu = pl.get(uui).index + 1;
                                System.out.println("No one died");
                            }

                            int yy = 0;
                            for (int op = 0; op < pl.size(); op++) {
                                if (pl.get(op).character.equals("Detective")) {
                                    yy++;
                                }
                            }

                            if (yy > 0) {
                                int free = 0;
                                for (int yest = 0; yest < pl.size(); yest++) {
                                    if (pl.get(yest).index == chindex) {
                                        free = yest;
                                    }
                                }

                                if (pl.get(free).character.equals("Mafia")) {
                                    int bb = pl.get(free).index + 1;
                                    pl.remove(free);
                                    maff.plastic.remove(0);
                                    System.out.println("Player" + " " + bb + " " + "has been voted out");


                                } else {


                                    if (jojo == 1) {
                                        System.out.println("Choose someone to vote");
                                        for (int in = 0; in < 1; in++) {
                                            B = sc.nextInt();
                                            B = B - 1;
                                            int he = 0;
                                            for (int ji = 0; ji < pl.size(); ji++) {
                                                if (pl.get(ji).index == B) {
                                                    he = ji;
                                                    break;
                                                }
                                            }
//				b=b-1;
//                                if (pl.get(he).character.equals("Detective")) {
//                                    System.out.println("Cannot test another detective");
//                                    in--;
//                                } else {
//                                    help = he;
//                                }
                                            //  help = he;
                                            int hr = 0;
                                            for (int hy = 0; hy < pl.size(); hy++) {
                                                if (pl.get(hy).index == pl.get(he).index) {
                                                    hr++;
                                                }
                                            }
                                            if (hr < 1) {
                                                System.out.println("Cannot choose this player");
                                                in--;
                                            } else {
                                                help = he;
                                            }


                                        }
                                        com.voting(pl, help);

                                    } else if (jojo == 0 && com.plastic.size() > 0) {
                                        System.out.println("\nCommuners will vote someone");
                                        com.ownvoting(pl);
                                    }
                                }


                            }
                            else {


                                if (jojo == 1) {
                                    System.out.println("Choose someone to vote");
                                    for (int in = 0; in < 1; in++) {
                                        B = sc.nextInt();
                                        B = B - 1;
                                        int he = 0;
                                        for (int ji = 0; ji < pl.size(); ji++) {
                                            if (pl.get(ji).index == B) {
                                                he = ji;
                                                break;
                                            }
                                        }
//				b=b-1;
//                                if (pl.get(he).character.equals("Detective")) {
//                                    System.out.println("Cannot test another detective");
//                                    in--;
//                                } else {
//                                    help = he;
//                                }
                                        //  help = he;
                                        int hr = 0;
                                        for (int hy = 0; hy < pl.size(); hy++) {
                                            if (pl.get(hy).index == pl.get(he).index) {
                                                hr++;
                                            }
                                        }
                                        if (hr < 1) {
                                            System.out.println("Cannot choose this player");
                                            in--;
                                        } else {
                                            help = he;
                                        }


                                    }
                                    com.voting(pl, help);

                                } else if (jojo == 0 && com.plastic.size() > 0) {
                                    System.out.println("\nCommuners will vote someone");
                                    com.ownvoting(pl);
                                }
                            }
                            if (maff.plastic.size() == (pl.size() - maff.plastic.size()) && maff.plastic.size() != 0 && pl.size() != 0) {
                                System.out.println("Mafia won");
                                for(int r=0;r<prinpl.size();r++){
                                    int hrt=prinpl.get(r).index+1;
                                    System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                                System.exit(0);
                                break;
                            }
                           else if (maff.plastic.size() == 0) {
                                System.out.println("Mafias are being eliminated");
                                for(int r=0;r<prinpl.size();r++){
                                    int hrt=prinpl.get(r).index+1;
                                System.out.println("player"+hrt+" "+ prinpl.get(r).character);}
                                System.exit(0);
                                break;
                            }


                        }



                    }

                }
                //	System.out.print(pl.size());


//		for(int i=0;i<n;i++) {
//			System.out.println(pl.get(i).hp+" "+pl.get(i).character);
//		}
                //System.out.print(pl.size());


            }

        }

