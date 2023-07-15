// FrontEnd Plus GUI for JAD
// DeCompiled : NoWrapEditorKit.class
//package CGRexpack;
import javax.swing.SizeRequirements;
import javax.swing.text.*;

class NoWrapEditorKit extends StyledEditorKit
    implements ViewFactory
{
	public static final long serialVersionUID = 0;
	private class NoWrapParagraphView extends ParagraphView
    {

        protected SizeRequirements calculateMinorAxisRequirements(int i, SizeRequirements sizerequirements)
        {
            if(shouldWrap)
            {
                return super.calculateMinorAxisRequirements(i, sizerequirements);
            } else
            {
                SizeRequirements sizerequirements1 = super.calculateMinorAxisRequirements(i, sizerequirements);
                sizerequirements1.minimum = sizerequirements1.preferred;
                return sizerequirements1;
            }
        }

        public int getFlowSpan(int i)
        {
            if(shouldWrap)
                return super.getFlowSpan(i);
            else
                return 0x7fffffff;
        }

        public NoWrapParagraphView(Element element)
        {
            super(element);
        }
    }


    private boolean shouldWrap;

    NoWrapEditorKit()
    {
        shouldWrap = false;
    }

    public void setWrap(boolean flag)
    {
        shouldWrap = flag;
    }

    public ViewFactory getViewFactory()
    {
        return this;
    }

    public View create(Element element)
    {
        String s = element.getName();
        if(s != null)
        {
            if(s.equals("content"))
                return new LabelView(element);
            if(s.equals("paragraph"))
                return new NoWrapParagraphView(element);
            if(s.equals("section"))
                return new BoxView(element, 1);
            if(s.equals("component"))
                return new ComponentView(element);
            if(s.equals("icon"))
                return new IconView(element);
        }
        return new LabelView(element);
    }

}
