package util;

public class SceneLink {

	// ATTRIBUTES 
	String originTag;
	Srring labelTag;
	
	String targetTag;

	public SceneLink(
		String originSceneTag, 
		String labelTag, 
		String targetSceneTag
	) {

		this.originTag = originSceneTag;
		this.labelTag = labelTag;
		this.targetTag = targetSceneTag;
	}
	
}