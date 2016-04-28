# AskHome

A programming platform that uses Amazon Alexa to work with SmartThings.  

It is unique in that it is Person, Place, Thing (noun) centric, not device centric.
This SmartThings smartApp is for groovy programmers....all the logic is in the program
not in "fill in the blanks".  This gives tremendous freedom for those that know code
to generate complex and intuitive interactions.  

For those that do not enjoy coding, AskHome is not for you.   MichaelS is developing a 
device centric app called AskAlexa that works really well. (I'll add the link when Michael is ready)
Fill in the blanks, and you can talk to devices by their capabilities...and more!  Go get that App!

The installation requires an Amazon Developer Account.  You need to create an Alexa skill
and a Lambda Function.  I've included screen shots that will help you configure the Alexa Skill,
and I've provided the code to talk to smartthings for Lambda, you only need to fill in a smartthings 
App id and token to make it work.

There are 3 steps for making AskHome.groovy your own.

1.  Decide what nouns you want to interact with.
2.  Add the devices that control or report information about the noun
3.  call capability and noun subroutines based on keywords

Nouns:  Person, Place, Thing  --  Like:  YOU, Living Room, Front Door

Devices:  SmartThings!   --  Like:  A presence sensor to detect YOU; Lights, 
switches, thermometers that control and sense a place, or a lock and a contact 
sensor that control and report on a door.

Alexa gives you words...A Noun, and Operator, and sometimes an operand.  A switch/case structure lists
the Nouns, and performs subroutine calls based on the Operator.  An example like setting the color in lighting.
So "ask home to light up the outside with green" could give you the words  Outside, light up, green.   
Yea, "light up" -- you can make up your own operators too, just like the Nouns.  You don't have to only use 
on, off, open, close, that are associated with the capabilities.

So if you like Alexa, and you want to ask her do anything...you're only limited by your imagination now.
So what will YOUR version of AskHome do?

