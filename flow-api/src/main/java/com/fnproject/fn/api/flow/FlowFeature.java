package com.fnproject.fn.api.flow;

import com.fnproject.fn.api.FunctionInvoker;
import com.fnproject.fn.api.RuntimeContext;
import com.fnproject.fn.api.RuntimeFeature;

/**
 *
 * The flow feature enables the Flow Client SDK and runtime behaviour in a Java function in order to use Flow in a function you must add the following to the function class:
 *
 *
 * <code>
 * import
 * @FnFeature(FlowFeature.class)
 * public class MyFunction {
 *
 *
 *     public void myFunction(String input){
 *         Flows.currentFlow()....
 *
 *     }
 * }
 *
 * </code>
 *
 * Created on 10/09/2018.
 * <p>
 * (c) 2018 Oracle Corporation
 */
public class FlowFeature implements RuntimeFeature {
    @Override
    public void initialize(RuntimeContext context) throws Exception {
        Class<?> continuationInvoker = Class.forName("com.fnproject.fn.runtime.flow.FlowContinuationInvoker");
        FunctionInvoker invoker = (FunctionInvoker)continuationInvoker.newInstance();
        context.addInvoker(invoker,FunctionInvoker.Phase.PreCall);
    }
}
