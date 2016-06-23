/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package grails.test.runtime

import groovy.transform.CompileStatic

/**
 * a TestPlugin for TestRuntime that supports {@link WebFlowUnitTestMixin}
 * 
 * @author Lari Hotari
 * @since 2.4.0
 *
 */
@CompileStatic
class WebFlowTestPlugin implements TestPlugin {
    String[] requiredFeatures = ['controller']
    String[] providedFeatures = ['webFlow']
    int ordinal = 0

    protected void clearWebFlowTestState(TestRuntime runtime) {
        runtime.removeValue("webFlowTestState")
    }
    
    public void onTestEvent(TestEvent event) {
        switch(event.name) {
            case 'afterClass':
                clearWebFlowTestState(event.runtime)
                break
        }
    }
    
    public void close(TestRuntime runtime) {
        
    }
}