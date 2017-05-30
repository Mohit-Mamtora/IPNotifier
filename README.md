# IPNotifier
IPNotifier Notify You When Your IP Will Change At That Time

  IPNotifier give you ip when ip will change at that time based on how you give RefreshRate number.
  Defalut RefreshRate=3000
  
  IPnotifier call OnChangeTo() method from OnIpchangeListioner interface when ip has been change.
  
  OnChangeTo() methos use Inetaddress parameter so you can take updatable ip easily.
  
  IPnotifier implemented runnable interface so make sure IPnotifier instance given to the thread.
  
  # In Android 
  
  When you want to use or handle widget from OnChangeTo() methdod you must be use 
  Handle object because IPNotifier call OnChangeTo() from thread.
  
  Use Demo.java 
