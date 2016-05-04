/**
 *  OAUTH Tool
 *
 *  Copyright 2016 Keith DeLong
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
definition(
    name: "OAUTH Tool",
    namespace: "n8xd",
    author: "n8xd",
    description: "Get an OAUTH ID token pair for THIS app...then replace the code in THIS app",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")

 
preferences {
    section(title: "Create an OAUTH ID/Token Pair") {
            try {
                def tok = createAccessToken()
                paragraph "   var STappID = '${app.id}';\n   var STtoken = '${tok}'\n"
            } catch (error) {
                 paragraph "Enable OAuth in the SmartApp editor under App Settings"
            }
    }
}
