'use strict';
exports.handler = function( event, context ) {
   var https = require( 'https' );
   
   var STappID = 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx';  // AppID from Apps Editor
   var STtoken = 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx';  //Token from Apps Editor
   //var STappID = '6f89555e-76f7-4264-b349-ffe05fe3ae39' // ID for Auto OAUTH
   //if (event.session.user.accessToken) {STtoken = event.session.user.accessToken; }
   
   if (event.request.intent.name == "Home") {
        var Operator = event.request.intent.slots.Operator.value;
        var Noun = event.request.intent.slots.Noun.value;
        var Operand = event.request.intent.slots.Operand.value;
        var Inquisitor = event.request.intent.slots.Inquisitor.value;
        if (!Operator) {Operator = "none";}
        if (!Noun) {Noun = "none";}
        if (!Operand) {Operand = "none";}
        if (!Inquisitor) {Inquisitor = "none";}
        var url = 'https://graph.api.smartthings.com/api/smartapps/installations/' + STappID + '/' + 
                 Noun + '/' + Operator + '/'+ Operand + '/' + Inquisitor  +'?access_token=' + STtoken;
        console.log(url)
        https.get( url, function( response ) {
            response.on( 'data', function( data ) {
                var resJSON = JSON.parse(data);
                var speechText = 'The App on SmartThings did not return any message.'
                if (resJSON.talk2me) { speechText = resJSON.talk2me; }
                console.log(speechText);
                output(speechText, context);
                console.log("after the fact");
            } );
        } );
    } else {
       output("Another intent goes here.", context)
    }
};


function output( text, context ) {
   var response = {
      outputSpeech: {
         type: "PlainText",
         text: text
      },
      card: {
         type: "Simple",
         title: "System Data",
         content: text
      },
   shouldEndSession: true
   };
   context.succeed( { response: response } );
}
