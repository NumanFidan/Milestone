
# Milestone
Hi! You can download the debug-apk file from here: [app-debug.apk
](https://github.com/NumanFidan/Milestone/raw/master/read.me/app-debug.apk) or

![](https://github.com/NumanFidan/Milestone/blob/master/read.me/indir.png)

** I used TMDB database to fetch all of these data.<br/>
**Popular Movies list is always fetching from TMDB API.<br/>
**Every time you reach at the end of the list new page will be loading from API.<br/>
**Once you enter a movie detail :<br/>
 * First, the app is checking the FireStore database cache.
 * If the movie is not available locally then it checks FireStore Database Server.
 * If the movie is not available at FireStore database than the app calls TMDB API to fetch data.
 * All the fetched data is being saved to FireStore database for further usages.<br/>
**So only one user makes an API request to get movie details, all others take information from FireStore or their FireStore local cache.
 
** 


## BASIC FLOW CHART

And this is the basic flowchart:

![](https://github.com/NumanFidan/Milestone/blob/master/read.me/basic_flow_chart.png)


## BASIC IN APP CAPTURE

![](https://github.com/NumanFidan/Milestone/blob/master/read.me/ezgif-2-4dd1b6f0667a.gif)
