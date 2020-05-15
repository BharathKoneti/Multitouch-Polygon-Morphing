# Multitouch Polygon Morphing
 Morphable shapes using touchlib device

Software Environment		:  JDK 1.5   
External Tools			: MT Mini Package/Touchlib , TUIO          
  Mouse


Linear Interpolation is a method that can be used for predicting. Very often things changes over a period of time: an object might change its position; a computer graphic image might change its shape; population might increase. Linear interpolation allows you to predict an unknown value (position, shape, population, etc.) if you know any two particular values and assume that the rate of change is constant. 
Linear interpolation assumes that:  
	You know two particular values.   
	The process is changing at a constant rate.  
	You desire to find an unknown data point.  
As a warm up example, consider flying a plane from a point ten miles north of Providence at a rate of 200 miles per hours headed due north. How far from Providence will you be after one-half hour? 
1.	We know the constant rate of change: 200 miles per hour in northern direction. 
2.	We know one point along the process: initially(time=0) we are 10 miles due north of Providence.
3.	We want to find another point along the process, knowing the new time is one-half hour. 
If you travel at 200 mph for one-half hour, you would have travelled 100 miles. You were initially 10 miles from Providence. Your final position will be: 
10 miles + 100 miles = 110 miles due north of Providence.
To solve this problem generally, we would take the distance the plane flown and add it to 10 miles to get the plane's distance from Providence. The distance that the plane flies is calculated using the distance formula, d = r * t, where ‘d’ is the distance the plane will travel, ‘r’ is the rate at which the plane flies (200 mph), and ‘t’ is the time spent flying. Thus at any time, the distance from Providence will be: 
Distance from Providence = 10 + 200 * t 

We can easily predict the distance north of Providence, that, the plane will be at any time.
Let us now pose a similar problem that uses linear interpolation for its solution. Suppose you start at a point ten miles due north of Providence, and end 250 miles due north of Providence. Your flight direction is due north. How far from Providence will you be when your flight time is 25% completed, assuming you travel at a constant rate of speed? 
The total distance for the flight is 250 miles - 10 miles = 240 miles.
If your speed and direction of flight are constant, then when your flight is completed you would have completed 25% of 240 miles, or 0.25 * 240 = 60 miles
We started ten miles north of Providence, so our final distance from the city will be 
10 miles + 60 miles = 70 miles


## HOW LINEAR INTERPOLATION WORKS:

### Keyframes
The extent to which an image changes from one frame to the next and the methods for controlling such changes are obviously important in sustaining the illusion of motion. A common basic means for envisioning and executing a series of changing images is to use ‘keyframes’, describing the extremes of a character's motion. Deducing the other “in-between” frames, requires a little artistic decision making. In traditional animation houses, an animator draws the keyframes and assistants and “mediators” draw the in-between frames. However, even with acetate cells to layer images and reuse stationary components, this is an extremely time-consuming task that requires skills and patience. Even a five minute animation movie short, for instance, has 5 minutes x 60 seconds/minute x 24 frames/second = 7,200 frames and a feature length film has over a hundred thousand. Although keyframes and pencil tests (sequences drawn with outlines and not yet filled in with colors) provide some feedback before each frame is created in full detail, the traditional process requires very careful advance planning and last minute experimentation can be prohibitively expensive. 
### In-betweening
The computer can expedite the animation process by producing in-between frames automatically. In its simple scenario, the goal is to animate a ball thrown in the air; starting at ground level, rising into the air while moving sideways, and returning to the ground. The three keyframes needed are the ball's beginning and end positions and highest point. Now, instead of drawing the intermediate frames by hand, the artist can choose to in-between these frames automatically. 
### Linear Interpolation
The simplest kind of automatic in-betweening is linear in-betweening which is done with a mathematical process of guessing intermediate locations called linear interpolation. To interpolate means, to calculate a new value in between two known values. Linear interpolation creates new values at equal distances along a line between two known values. In animating, an object moving between two points in space, linear in-betweening creates new frames at equal intervals along a straight line between two of the keyframes, the number of intervals (and thus number of frames) is determined by the user. If two of the keyframes are one second apart, for example, an artist has specified that the animation should run at 10frames/sec, and then the time between the frames is represented by 10 frames shown at ten equal intervals. 
### Key Frame Animation
Key frames mark important visual transitions (extremes of action). 
In-betweening is creation of intermediate frames between the key frames which can be calculated by a Computer. 
### Temporal Sampling 
A digitized image is composed of discrete samples of a continuous image, arranged to create the illusion of a continuous picture.
Similarly, film recording takes samples of an image at fixed time intervals--i.e., temporal samples. When these are arranged and played at a certain rate (24 frames/sec for film, 30 frames/sec for video, 60 to 70 for some fast-moving computer graphics applications), an illusion of continuous motion is created. 
In-betweening is letting the computer produce additional temporal samples (frames) between predefined key frames in an animation. 


### Problem: Hard to create truly life-like animation unless keyframes are designed for almost every other frame, True in both computer and traditional animation.
Computer in-betweening is often used as aid for storyboarding, testing sequences (as in Jurassic Park). 
### Geometric Transformation and Animation 
An important distinction:  
	Geometric transformations do not create motion; they cause instantaneous changes.   
	Intermediate frames necessary to create illusion of motion (animation) are created by calculating additional transformations (in-betweening).   
The Math behind In-betweening:  
	New way of thinking about linear paths that will enable us to calculate the in-between frames. Let's begin with lines:   
	Given a line segment from v1 to v2, how to express midpoint? Use equal combinations of both point positions  
o	x = 1/2 (x1 + x2) = (1/2) x1 + (1/2) x2   
o	y = 1/2 (y1 + y2) = (1/2) y1 + (1/2) y2   
	Three-fourths of the way :- Use a combination of three quarters of the final destination and one quarter of the starting point,  
o	x = (1/4) x1 + (3/4) x2   
o	y = (1/4) y1 + (3/4) y2   
	Can think of this as weighted averages of point positions   
	So, how is this related to in-betweening?   
o	By letting our position on this very practically defined line, depend on another variable such as elapsed time (represented by the letter ‘t’ but note that ’ t’ does not necessarily have to be time)   
	Conveniently, we have defined our trip to begin at t = 0 and end at t = 1.   
	So, for a parameter t   
o	x = (1 - t) x1 + tx2   
o	y = (1 - t) y1 + ty2   
	Because the line definition now depends on a third parameter (not x or y, but t) it is called a parametric equation.   

