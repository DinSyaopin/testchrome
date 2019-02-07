# TestChrome
Automatized tests for Chrome browser.

# Requirements
The minimum requirements is that you've installed jre1.8.0_201 or higher version and chrome.

# Quick start
-1.Run chrometestapp.jar  

-2.Click button *Find file*  

-3.Choose file of appropriate format: .txt, .xml, .xls, .xlsx, .json  

>File decoration must match to examples in app directory.  

-4.Click button *Test*.  

>New chrome window will be opened. Then should be done some actions on a browser and in the end browser will be closed.  
>Logging information saves in the app directory with pattern *"./logs/app-%d{yyyy-MM-dd}.log"* as well as in textarea of app.  
>Screenshots that was created during the tests puts to app directory with pattern *"screen"+"dd.MM.yy"+".png"*.

-5.You can return to step 2 and go on or close app simply push exit button or *close* item of menu.  
