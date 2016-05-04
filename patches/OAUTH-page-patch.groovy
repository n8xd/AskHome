// Use inputs to attach smartthings devices to this app
preferences {
   page(name: "connectDevPage")
   }

def connectDevPage() {
   dynamicPage(name: "connectDevPage", title:"Connect Devices", install: true  uninstall: true ) {
      section(title: "Select Devices") {
        input "brlight", "capability.switch", title: "Select the Bedroom Light", required: true, multiple:false
        //  ALL YOUR INPUTS go here

      }
      if (!state.tok) {          
          try {
             state.tok = createAccessToken()
          } catch (error) {
             state.tok = null
          }
      }
      section(title: "Show the OAUTH ID/Token Pair") {
        paragraph "   var STappID = '${app.id}';\n   var STtoken = '${state.tok}';\n"
      }
   }
}


