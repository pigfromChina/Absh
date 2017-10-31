package bsh;

class BSHThrowStatement extends SimpleNode
{
	BSHThrowStatement(int id) { super(id); }

	public Object eval( CallStack callstack, Interpreter interpreter)  
		throws EvalError
	{
		Object obj = ((SimpleNode)jjtGetChild(0)).eval(callstack, interpreter);

		// need to loosen this to any throwable... do we need to handle
		// that in interpreter somewhere?  check first...
		if(!(obj instanceof Exception))
			throw new EvalError("Expression in 'throw' must be Exception type",
				this, callstack );

		// wrap the exception in a TargetException to propagate it up
		throw new TargetError( (Exception)obj, this, callstack );
	}
}

