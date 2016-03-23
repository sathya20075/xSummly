package com.apps.main;


import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SummlyMain
{
	
	public static void main(String args[]){
	
		HashMap<String,BigDecimal> getContentRanks =null;
		String title ="Swayy is a beautiful new dashboard for discovering and curating online content [Invites]";
		
		String content = "";
		
		content += "Lior Degani, the Co-Founder and head of Marketing of Swayy, pinged me last week when I was in California to tell me about his startup and give me beta access. I heard his pitch and was skeptical. I was also tired, cranky and missing my kids – so my frame of mind wasn't the most positive.\n";
		content += "I went into Swayy to check it out, and when it asked for access to my Twitter and permission to tweet from my account, all I could think was, \"If this thing spams my Twitter account I am going to bitch-slap him all over the Internet.\" Fortunately that thought stayed in my head, and not out of my mouth.\n";
		content += "One week later, I'm totally addicted to Swayy and glad I said nothing about the spam (it doesn't send out spam tweets but I liked the line too much to not use it for this article). I pinged Lior on Facebook with a request for a beta access code for TNW readers. I also asked how soon can I write about it. It's that good. Seriously. I use every content curation service online. It really is That Good.\n";
		content += "What is Swayy? It's like Percolate and LinkedIn recommended articles, mixed with trending keywords for the topics you find interesting, combined with an analytics dashboard that shows the trends of what you do and how people react to it. I like it for the simplicity and accuracy of the content curation.\n"; 
		content += "Everything I'm actually interested in reading is in one place – I don't have to skip from another major tech blog over to Harvard Business Review then hop over to another major tech or business blog. It's all in there. And it has saved me So Much Time\n";
		content += "After I decided that I trusted the service, I added my Facebook and LinkedIn accounts. The content just got That Much Better. I can share from the service itself, but I generally prefer reading the actual post first – so I end up sharing it from the main link, using Swayy more as a service for discovery.\n";
		content += "I'm also finding myself checking out trending keywords more often (more often than never, which is how often I do it on Twitter.com).\n\n\n";
		content += "The analytics side isn't as interesting for me right now, but that could be due to the fact that I've barely been online since I came back from the US last weekend. The graphs also haven't given me any particularly special insights as I can't see which post got the actual feedback on the graph side (however there are numbers on the Timeline side.) This is a Beta though, and new features are being added and improved daily. I'm sure this is on the list. As they say, if you aren't launching with something you're embarrassed by, you've waited too long to launch.\n";
		content += "It was the suggested content that impressed me the most. The articles really are spot on – which is why I pinged Lior again to ask a few questions:\n";
		content += "How do you choose the articles listed on the site? Is there an algorithm involved? And is there any IP?\n";
		content += "Yes, we're in the process of filing a patent for it. But basically the system works with a Natural Language Processing Engine. Actually, there are several parts for the content matching, but besides analyzing what topics the articles are talking about, we have machine learning algorithms that match you to the relevant suggested stuff. For example, if you shared an article about Zuck that got a good reaction from your followers, we might offer you another one about Kevin Systrom (just a simple example).\n";
		content += "Who came up with the idea for Swayy, and why? And what's your business model?\n";
		content += "Our business model is a subscription model for extra social accounts (extra Facebook / Twitter, etc) and team collaboration.\n";
		content += "The idea was born from our day-to-day need to be active on social media, look for the best content to share with our followers, grow them, and measure what content works best.\n";
		content += "Who is on the team?\n";
		content += "Ohad Frankfurt is the CEO, Shlomi Babluki is the CTO and Oz Katz does Product and Engineering, and I [Lior Degani] do Marketing. The four of us are the founders. Oz and I were in 8200 [an elite Israeli army unit] together. Emily Engelson does Community Management and Graphic Design.\n";
		content += "If you use Percolate or read LinkedIn's recommended posts I think you'll love Swayy.\n";
		content += "Want to try Swayy out without having to wait? Go to this secret URL and enter the promotion code thenextweb . The first 300 people to use the code will get access.\n";
		content += "Image credit: Thinkstock";
		
		SummlyMain summly = new SummlyMain();
		//summly.splitContentToSentences(content);
		//summly.splitContentToParagraphs(content);
		String sen1 ="Want to try Swayy out without having to wait? Go to this secret URL and enter the promotion code thenextweb . The first 300 people to use the code will get access.";
		String sen2 ="This is not nature god";
		String Summary = null;
		//BigDecimal norm =summly.returnNormalizationValueOfSentences(sen1,sen2);
		
		//summly.formatSentences(sen1);
		getContentRanks=summly.getSentenceRanks(content);
		
		/*Iterator contentIterator = getContentRanks.keySet().iterator();
		while(contentIterator.hasNext())
		{
			String key = contentIterator.next().toString();
			//System.out.println("Key: "+ key);
			//System.out.println("Value:" +getContentRanks.get(key));
			
		}*/
		Summary = summly.getSummary(title, content, getContentRanks);
		System.out.println(Summary);
		System.out.println("Original Length: " +content.length());
		System.out.println("Summary Length: " +Summary.length());
	}
	
	public List<String> splitContentToSentences(String content)
	{
		
		List<String> sentencesrepo = null;
		
		if(content.length() != 0)
		{
			System.out.println("Length:" +content.length());
		 String[] result = content.split(".\n");
		 sentencesrepo = new ArrayList<String>();
		 for(String s:result){
			// System.out.println(s);
			 sentencesrepo.add(s);
		 }
		}
		return sentencesrepo;
	}
	
	public List<String> splitContentToParagraphs(String content)
	{
		List<String> paragraphrepo = null;
		if(content.length() != 0)
		{
			String[] result = content.split("\n\n");
			paragraphrepo = new ArrayList<String>();
			for(String s:result){
				//System.out.println(s);
				paragraphrepo.add(s);
			}
		}
		return paragraphrepo;
	}
    
	public String formatSentences(String Sentence)
	{
		String sentence = null;
		if(!Sentence.isEmpty())
		{
			sentence = Sentence.replaceAll("\\W*", "");
			//System.out.println("Sentence: " +sentence);
		}
		
		return sentence;
	}
	
	/**
	 * @param sen1
	 * @param sen2
	 */
	public BigDecimal returnNormalizationValueOfSentences(String sentence1, String sentence2)
	{
		String[] str1Array={};
		String[] str2Array={};
		BigDecimal normValue;
		BigDecimal commonTokensSize;
		BigDecimal averageSentenceLength;
		/*sen1 ="This is the nature god for sure";
		sen2 ="This is not nature god";*/
		if(sentence1.isEmpty() != true)
		{
			str1Array = sentence1.replace(".", "").replace(",", "").replace("?", "").replace("!","").split(" ");
			str2Array = sentence2.replace(".", "").replace(",", "").replace("?", "").replace("!","").split(" ");
		}
		else{
			System.exit(0);
		}
		 
		
		Collection<String> listOne = new ArrayList<String>(Arrays.asList(str1Array));
		Collection<String> listTwo = new ArrayList<String>(Arrays.asList(str2Array));
             
		listOne.retainAll( listTwo );
		//System.out.println( listOne );
		int sentenceLength = (str1Array.length+str2Array.length)/2;
		commonTokensSize = new BigDecimal(listOne.size());
		averageSentenceLength = new BigDecimal(sentenceLength);
		
		normValue = commonTokensSize.divide(averageSentenceLength, 4, RoundingMode.CEILING);
		
		//System.out.println(normValue);		
		
		return normValue;
		
	}
	
    /**
     * @param content
     */
    public HashMap<String,BigDecimal> getSentenceRanks(String content)
    {
    	
    	int sentencerepoLength=0;
    	BigDecimal score;
    	BigDecimal[][] scorerepo={};
    	List<String> sentencesList = null;
    	HashMap<String,BigDecimal> sentDict = null;
    	
    	
    	if(content.isEmpty())
    	{
    		System.out.println("Empty Content..Exiting the app..");
    		System.exit(0);
    	}
    	else
    	{
    		sentencesList = splitContentToSentences(content);
    		if(sentencesList.size() != 0)
    		{    			
    			sentencerepoLength=sentencesList.size();
    			scorerepo =  new BigDecimal[sentencerepoLength][sentencerepoLength];
    			for(int i=0;i<=sentencerepoLength-1;i++)
    			{
    				for(int j=0;j<=sentencerepoLength-1;j++)
    				{
    					scorerepo[i][j]=returnNormalizationValueOfSentences(sentencesList.get(i),sentencesList.get(j));
    				}
    			}
    			
    			//Creating Sentences dictionary with norm value.
    			sentDict = new HashMap<String,BigDecimal>();
    			for(int i=0;i<=sentencerepoLength-1;i++)
    			{
    				score=new BigDecimal(0);
    				for(int j=0;j<=sentencerepoLength-1;j++)
    				{
    					if(i==j){
    						continue;
    					}
    					score = score.add(scorerepo[i][j]);
    					
    				}
    				sentDict.put(formatSentences(sentencesList.get(i)), score);
    			}
    		}
    		else
    		{
    			System.out.println("Sentences repository is null.. Exiting..");
    			System.exit(0);
    		}
    	}
    	return sentDict;
    }
	
    public String getBestSentence(String paragraph, HashMap<String,BigDecimal> sentenceDict)
    {
    	
    	String bestSentence = null;
    	String sentenceKey = null;
    	BigDecimal maxValue = new BigDecimal(0);
    	List<String> sentencesList = null;
    	
    	
    	sentencesList = splitContentToSentences(paragraph);
    	
    	if(sentencesList.size() < 2)
    	{
    		return null;
    	}
    	
    	for(String s:sentencesList)
    	{
    		sentenceKey=formatSentences(s);
    		
    		try
    		{
    			if((!sentenceKey.isEmpty()) && (sentenceDict.get(sentenceKey).compareTo(maxValue)) == 1)
    			{
    				maxValue = sentenceDict.get(sentenceKey);
    				bestSentence = s;
    				System.out.println("Matches!!");
    				
    			}
        		else
        		{
        			continue;
        		}
    		}catch(NullPointerException ex)
    		{
    			ex.printStackTrace();
    		}
    		
    					
    	}
    	
    	return bestSentence;    	
     }
    
	 public String getSummary(String title, String content, HashMap<String,BigDecimal> sentenceDict)
	 {
		 
		 List<String> paragraphs = null;
		 String sentence = null;
		 StringBuffer bString = new StringBuffer();
		 
		 paragraphs=splitContentToParagraphs(content);
		 
		 
		
		 bString.append(title);
		 bString.append(" ");
		 
		 
		 for(String paragraph:paragraphs)
		 {
			 sentence = getBestSentence(paragraph,sentenceDict).trim();
			 bString.append(sentence);
			 
		 }
		 return bString.append("\n").toString();
	 }
}
