# TestChrome
Automatized tests for Chrome browser.

# Requirements
The minimum requirements is that you've installed jre1.8.0_201 or higher version and chrome.

# Quick start
-1.Run chrometestapp.jar  

-2.Click button **Find file**  

-3.Choose file of appropriate format: .txt, .xml, .xls, .xlsx, .json  

>File decoration must match to examples in app directory.  

-4.Click button **Test**.  

>New chrome window will be opened. Then should be done some actions on a browser and in the end browser will be closed.  
>Logging information saves in the app directory with pattern *"./logs/app-%d{yyyy-MM-dd}.log"* as well as in textarea of app.  
>Screenshots that was created during the tests puts to app directory with pattern *"screen"+"dd.MM.yy"+".png"*.

-5.You can return to step 2 and go on or close app with simply pushing exit button or *close* item of menu.  

# Supported test commands
Look at the test.xml example:
      
      <?xml version="1.0" encoding="utf-8" ?>
      <command>
          <command action="openurl" params="https://google.com" description="Open Browser" />
          <command action="Click" params="//input[@class='gLFyf gsfi']" description="Click Element" />
          <command action="setValue" params="//input[@class='gLFyf gsfi'] | Netcracker" description="Set Text Value" />
          <command action="Click" params="//div[@class='VlcLAe']//input[@name='btnK']" description="Click Search Button" />
          <command action="Click" params="(//div[@class='g'])[1]//div[@class='r']/a[1]" description="Click First Result" />
          <command action="screenShot" params="" description="Take screenshot" />
      </command>
     
App implemented four types of action: **openurl**, **click**, **setvalue**, **screenshot**. Register doesn't matter.  

**Params** attribute of action **openurl** should consists of url.  

**Params** attribute of action **click** should consists of Xpath request.  

**Params** attribute of action **setvalue** should consists of "xpath request" + '|' + "some text".  

**Params** attribute of action **screenshot** ignored.  
