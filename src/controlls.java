
import java.util.Timer;
import java.util.TimerTask;
//import controlls.do_controller;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;

public class controlls {

	 public Controller []contral=ControllerEnvironment.getDefaultEnvironment().getControllers();
	 public Controller controller=null;
	 public Event event=new Event();
	 public EventQueue eq;
	 public Component com;
	 public Component.Identifier id;//按鈕名稱
	 public int stick_x;//蘑菇投X軸
	 public int stick_y;//蘑菇投Y軸
	 public float data;//poll的按鈕數值
	 public boolean if_LB=false;//LT
	 public boolean if_RB=false;//RT

	
	 public Component.Identifier old_id;//上次poll的按鈕名稱 應每10 pixel歸NULL
	 public Component.Identifier first_id;
	 public float old_data=(float)0.0;//上次poll的按鈕數值 應每10 pixel歸NULL
	 public int line_y=869;//底線(上底)
	 public int line_height=50;//底線厚度
	 public int now_position_y=900;//目前底排位置(下底)//test_value
	 public int now_height=50;//目前底排厚度
	 public char target_buttons[]=new char[4];//目前底排內容 ex: 1010
	 public char next_target_buttons[]=new char[4];//下一排內容
	 public boolean if_have_stuff=true;//底排是否為空 空則false
	 public boolean if_scored=false;
	 public boolean if_x=false;


	 public int score = 0;//分數
	 public String status=null;//perfect,good,bad,nothing
	 public double mushroom=800;//蘑菇頭位置(指針)

	 
	 public int c=0;//data重複
	 public int count;//test
	 public boolean old_id_ed=false;
	 
	 controlls()
	 {
		 target_buttons[0]='1';
		 target_buttons[1]='1';
		 target_buttons[2]='1';
		 target_buttons[3]='1';
		for(int i=0;i<contral.length;i++)
		{
			//System.out.println(contral[i]);
			if(contral[i].getType()==Controller.Type.STICK)//getControllerType
			{
				System.out.println(contral[i]);
				System.out.println(i);
				controller=contral[i];
			}
		}
		eq=controller.getEventQueue();
		controller.poll();//to event//
		eq.getNextEvent(event);
		com=event.getComponent();
		id=com.getIdentifier();
		old_id=id;
		first_id=id;
		 do_timer();
	 }
	 
	 
	public void do_timer()
	 {
		Timer timer = new Timer();
		TimerTask do_controller = new TimerTask()
		{
		public void run() {
			
			//System.out.println(target_buttons[0]+" "+target_buttons[1]+" "+target_buttons[2]+" "+target_buttons[3]);
			System.out.println(mushroom+" "+c+" "+old_id.toString()+" "+data+" "+count+" "+if_LB+" "+if_RB);
			controller.poll();//to event//
			eq.getNextEvent(event);
			com=event.getComponent();
			if(old_id.toString()=="x"&&mushroom>=616&&mushroom<=1414&&Math.abs(old_data)>0.02
			&&if_x==true)//for mushroom
				{
					c++;
						mushroom+=old_data*5;
						if(mushroom>=1414&&mushroom<1422)//越位
						{
							if(data>=0)
							mushroom-=6;
						}
						if(mushroom<=616&&mushroom>605)//越位
						{
							if(data<=0)
							mushroom+=6;
						}
					
				}

			if(com!=null)
			{ 
				
				id=com.getIdentifier();
				if(id.toString()=="x")//
				{
					if(Math.abs(data)>0.02)
					{
						if_x=true;
					}
					else
					if_x=false;


				}
		
				//data=com.getPollData();
				
				if(id.toString()!="ry"&&id.toString()!="rx"&&id.toString()!="rz"
						&&id.toString()!="y"&&id.toString()!="z")//trigger進不來
				{
					data=com.getPollData();
					//count++;
					//System.out.println(mushroom+" "+c+""+data+" "+id.toString()+" "+if_LB+" "+if_RB);
					if(id.toString()=="pov")
					{
					   if(data!=old_data)//沒有連續按
					   {
						pov();
					   }
					   
					}
					 else if(id.toString()=="0"||id.toString()=="2")//2,0
					{
						 if(id!=old_id)//沒有連續按
						{
							x_b();
						}
					}

					else if(id.toString()=="4")//LB
					{
						if(data==1.0)
						if_LB=true;
						else
						if_LB=false;

					}
					else if(id.toString()=="5")//RB
					{
						if(data==1.0)
						if_RB=true;
						else
						if_RB=false;
					}
					

					old_id=id;
					old_data=data;
				}

				
				
			}
			
			if(now_position_y>=line_y&&now_position_y<=line_y+line_height+now_height&&if_scored==false)//線中間
				{

					if(target_buttons[0]=='2'||target_buttons[1]=='2'
					||target_buttons[2]=='2'||target_buttons[3]=='2')//滑軌模式
					{
						if(if_LB==true&&if_RB==true)//有沒有按RB,LB
						{
							if(mushroom>=1215)
								target_buttons[3]='0';
							
							else if(mushroom>=1015)
								target_buttons[2]='0';

							else if(mushroom>=815)
								target_buttons[1]='0';

							else if(mushroom>=615)
								target_buttons[0]='0';
						}
						

					}


					if(target_buttons[0]=='0'&&target_buttons[1]=='0'&&
							target_buttons[2]=='0'&&target_buttons[3]=='0'
							&&if_have_stuff==true
							&&now_position_y-line_y>=line_height-6
							&&now_position_y-line_y<=line_height+1)//perfect//底牌有東西
					{
						status="perfect";
						score+=300;
						if_scored=true;
					}
					else if(target_buttons[0]=='0'&&target_buttons[1]=='0'&&
					target_buttons[2]=='0'&&target_buttons[3]=='0'
					&&if_have_stuff==true)//good//底牌有東西
					{
						status="good";
						score+=100;
						if_scored=true;
					}

					else if(target_buttons[0]!='0'||target_buttons[1]!='0'||
					target_buttons[2]!='0'||target_buttons[3]!='0'
					&&now_position_y > line_y+line_height+now_height
					&&if_have_stuff==true)//bad//底牌有東西
					{
						status="bad";
						if_scored=true;
					}
					if(now_position_y > line_y+line_height+now_height)//整個超出範圍，在這裡target要換下一排 
					{
						if_have_stuff=false;
						shift_next_line();
					}
					
					
				}
				
				
						
					

			
			
			 
	}
};

	TimerTask reset=new TimerTask()//danger//每10毫秒做reset
	{
		public void run()
		 {
			 if(id.toString()!="x"&&id.toString()!="ry"&&id.toString()!="rx"&&id.toString()!="rz"
			 &&id.toString()!="y"&&id.toString()!="z")
			 {
				old_id=Component.Identifier.Axis.X;
				old_data=(float)0.0;
			 }
			 

		}
	};


		timer.schedule( do_controller, 0,1);//每一毫秒做do_controller
		timer.schedule( reset, 0,10);//每10毫秒做reset
}

	 public void x_b()
	 {
		if(now_position_y<=line_y+line_height+now_height&& 
		now_position_y>=line_y)//在底線範圍內
		{
			//System.out.println("in_xb"+id.toString());
			switch(id.toString())
			{
			case "0"://x
				target_buttons[2]='0';
				break;
			case "2"://b
				target_buttons[3]='0';
				break;
			default:
				break;
				
			}
		}
	 }

	 public void pov()
	 {
		
		if(now_position_y<=line_y+line_height+now_height&& 
		now_position_y>=line_y)//在底線範圍內
		{
			//System.out.println("in_pov"+data);
			switch((int)(data*2))
			{
				case 1://右
					target_buttons[1]='0';
					break;
				case 2://左
					target_buttons[0]='0';
					break;

				default:
					break;
					
			}
		}		
	 }

	 public void shift_next_line()//整個超出範圍
	 {
		 if_scored=false;
		/* for(int i=0;i<4;i++)
		 {
			 target_buttons[i]=next_target_buttons[i];
		 }*/

		 if(target_buttons[0]=='0'&&target_buttons[1]=='0'&&target_buttons[2]=='0'&&target_buttons[3]=='0')
			 if_have_stuff=false;
		 else 
		 	if_have_stuff=true;
	 }
	
}
