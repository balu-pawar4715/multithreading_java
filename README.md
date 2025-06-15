# Java Coding Practice
#git commands
echo "# multithreading_java" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/balu-pawar4715/multithreading_java.git
git push -u origin main

### मल्टीथ्रेडिंगचे फायदे (Advantages of Multithreading)

- एकाच वेळी अनेक कामे (tasks) पार पाडता येतात, त्यामुळे कार्यक्षमता (performance) वाढते.
- CPU चा पूर्ण वापर होतो, idle वेळ कमी होतो.
- मोठ्या प्रोग्रॅम्समध्ये प्रतिसाद वेळ (response time) कमी होतो.
- बॅकग्राउंडमध्ये टास्क (जसे की auto-save, file download) सहज चालवता येतात.
- GUI applications मध्ये user interface hang न होता smooth अनुभव मिळतो.

हे workspace Java प्रोग्रॅमिंग सरावासाठी आहे. खालील सर्व Java फाइल्सचे मराठीत स्पष्टीकरण दिले आहे:

---

## com/ex/multi_thread/ThreadLifeCycle.java चे स्पष्टीकरण

ही फाइल थ्रेडचे विविध अवस्थांचे (Thread States) उदाहरण देते:
- थ्रेड तयार केल्यावर (NEW state) मेसेज प्रिंट होतो.
- `start()` केल्यावर थ्रेड RUNNABLE state मध्ये येतो आणि "is running" मेसेज प्रिंट करतो.
- `Thread.sleep(1000)` मुळे थ्रेड TIMED_WAITING state मध्ये जातो.
- झोपेतून उठल्यावर पुन्हा RUNNABLE state मध्ये येतो आणि "woke up from sleep" मेसेज प्रिंट करतो.
- शेवटी थ्रेड पूर्ण झाल्यावर TERMINATED state मध्ये जातो आणि "is finishing" मेसेज प्रिंट करतो.
- `main()` मध्ये `join()` वापरल्यामुळे मुख्य थ्रेड, ThreadLifeCycle पूर्ण होईपर्यंत थांबतो.

यामुळे थ्रेडच्या सर्व महत्वाच्या अवस्थांचा अनुभव घेता येतो.

---

## com/ex/multi_thread/MyRunnable.java

ही फाइल `Runnable` इंटरफेस implement करते. `run()` मेथडमध्ये "MyRunnable is running in a thread!" हा मेसेज प्रिंट होतो. `main()` मध्ये हा Runnable ऑब्जेक्ट एका Thread मध्ये पास करून सुरू केला आहे. यामुळे हा मेसेज वेगळ्या थ्रेडमध्ये चालतो.

---

## com/ex/multi_thread/MyThread.java

ही फाइल `Thread` क्लास extend करते. `run()` मेथडमध्ये "MyThread is running in a thread!" हा मेसेज प्रिंट होतो. `main()` मध्ये `MyThread` चा ऑब्जेक्ट तयार करून `start()` केल्यावर हा मेसेज वेगळ्या थ्रेडमध्ये दिसतो.

---

## com/ex/multi_thread/MyDaemonThread.java

ही फाइल डेमन थ्रेडचे उदाहरण देते. `run()` मध्ये सतत "Auto-saving user data in the background..." हा मेसेज दर 2 सेकंदांनी प्रिंट होतो. हा थ्रेड डेमन म्हणून सेट केला आहे (`setDaemon(true)`). मुख्य थ्रेड ५ स्टेप्ससाठी "User is working... step X" प्रिंट करतो. मुख्य थ्रेड संपला की JVM बंद होते आणि डेमन थ्रेडही थांबतो.

---

## com/ex/multi_thread/MyYield.java

ही फाइल `Thread.yield()` वापरते. दोन थ्रेड्स (`Thread-1`, `Thread-2`) तयार होतात. प्रत्येक थ्रेड ५ वेळा आपले नाव आणि स्टेप प्रिंट करतो आणि प्रत्येक वेळी `yield()` कॉल करतो, म्हणजे control दुसऱ्या थ्रेडला देण्याचा प्रयत्न करतो.

---

## com/ex/multi_thread/MyJoin.java

ही फाइल `join()` मेथडचे उदाहरण देते. दोन थ्रेड्स तयार होतात. `Thread-1` सुरू केल्यावर `main` थ्रेड `t1.join()` मुळे `Thread-1` पूर्ण होईपर्यंत थांबतो. नंतर `Thread-2` सुरू होतो. त्यामुळे दोन्ही थ्रेड्सचे आउटपुट एकामागोमाग एक (serially) दिसते.

---

## com/ex/multi_thread/MyThreadSchedular.java

ही फाइल थ्रेड शेड्युलर आणि प्रायोरिटीचे (Thread Scheduler & Priority) उदाहरण देते:
- `MyThreadSchedular` हा `Thread` क्लास extend करतो.
- प्रत्येक थ्रेड ३ वेळा आपले नाव आणि स्टेप प्रिंट करतो.
- `main()` मध्ये तीन थ्रेड्स तयार केले आहेत: t1, t2, t3.
- t1 ला सर्वात कमी priority (MIN_PRIORITY), t2 ला normal (NORM_PRIORITY), आणि t3 ला सर्वात जास्त priority (MAX_PRIORITY) दिली आहे.
- सर्व थ्रेड्स सुरू केल्यावर, JVM चा थ्रेड शेड्युलर कोणत्या थ्रेडला किती वेळ CPU देतो हे priority वर अवलंबून असते, पण हे हमखास नाही (हे JVM आणि OS वर अवलंबून असते).
- त्यामुळे output मध्ये कधी t3 जास्त वेळा चालेल, कधी इतरही चालू शकतात.

यामुळे थ्रेड प्रायोरिटी आणि शेड्युलिंग कसे काम करते हे समजते.

---

## com/ex/multi_thread/MyArray.java

ही फाइल Object array मध्ये कसे insert करायचे हे दाखवते:
- `Person` नावाचा एक साधा क्लास आहे, ज्यात नाव आणि वय ही दोन फील्ड्स आहेत.
- `MyArray` क्लासमध्ये `Person` टाईपचे array तयार केले आहे.
- तीन वेगवेगळ्या Person ऑब्जेक्ट्स array मध्ये ठेवले आहेत.
- नंतर foreach loop वापरून सर्व ऑब्जेक्ट्स प्रिंट केले आहेत.

यामुळे Object array मध्ये कसे values insert करायचे आणि वापरायचे हे समजते.

---

## com/ex/multi_thread/MyThreadPool34nm.23
java

ही फाइल Java मध्ये Thread Pool कसा वापरायचा हे दाखवते:
- `ExecutorService service = Executors.newFixedThreadPool(3);` हे 3 थ्रेड्स असलेला पूल तयार करते. म्हणजे एकावेळी 3 टास्क्स चालू शकतात.
- `for` लूपमध्ये 5 वेगवेगळ्या टास्क्स पूलमध्ये execute केले आहेत.
- प्रत्येक टास्कमध्ये: "Task X is running by Thread-Name" प्रिंट होते, 1 सेकंद झोप, आणि "Task X completed by Thread-Name" प्रिंट होते.
- `service.shutdown();` नंतर पूल बंद केला जातो.

मुख्य मुद्दा: Thread Pool वापरल्याने resource management चांगले होते, आणि अनेक टास्क्स एकाच वेळी (पॅरलल) चालवता येतात. येथे 5 टास्क्स आहेत, पण एकावेळी फक्त 3 चालतील, उरलेले टास्क्स थ्रेड मोकळा झाल्यावर चालू होतील.

---

अधिक सरावासाठी नवीन Java फाइल्स तयार करा आणि त्यांचे स्पष्टीकरण येथे जोडा.

## How to Run

1. Open a terminal in this directory.
2. Compile the program:
   ```powershell
   javac HelloWorld.java
   ```
3. Run the program:
   ```powershell
   java HelloWorld
   ```

Feel free to add more Java files for additional practice!
