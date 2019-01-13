/* 
 *  Home Automation
 *  Coder - Mayoogh Girish
 *  Website - http://bit.do/Avishkar
 */
 
char data = 0;                //Variable for storing received data
void setup() 
{
  Serial.begin(9600);         //Sets the data rate in bits per second (baud) for serial data transmission
  pinMode(2, OUTPUT);        
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(7, OUTPUT);
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
}
void loop()
{
  if(Serial.available() > 0)  // Send data only when you receive data:
  {
    data = Serial.read();      //Read the incoming data and store it into variable data
    Serial.print(data);        //Print Value inside data in Serial monitor
    Serial.print("\n");        //New line 
    
    if(data == 'a')            
      digitalWrite(2, HIGH);  
    else if(data == 'b')       
      digitalWrite(2, LOW);
      
    else if(data == 'c')       
      digitalWrite(3, HIGH);
    else if(data == 'd')       
      digitalWrite(3, LOW);
      
    else if(data == 'e')       
      digitalWrite(4, HIGH);
    else if(data == 'f')       
      digitalWrite(4, LOW);
      
    else if(data == 'g')       
      digitalWrite(5, HIGH);
    else if(data == 'h')       
      digitalWrite(5, LOW);
      
    else if(data == 'i')       
      digitalWrite(6, HIGH);
    else if(data == 'j')       
      digitalWrite(6, LOW);
      
    else if(data == 'k')       
      digitalWrite(7, HIGH);
    else if(data == 'l')       
      digitalWrite(7, LOW);
      
    else if(data == 'm')       
      digitalWrite(8, HIGH);
    else if(data == 'n')       
      digitalWrite(8, LOW);
      
    else if(data == 'o')       
      digitalWrite(9, HIGH);
    else if(data == 'p')       
      digitalWrite(9, LOW);
  }                            
 
}                 
