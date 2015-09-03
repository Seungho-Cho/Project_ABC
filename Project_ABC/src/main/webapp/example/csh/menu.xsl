<?xml version="1.0" encoding="euc-kr" ?>
  
<xsl:stylesheet 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method="html" indent="yes" encoding="euc-kr" />

	<xsl:template match="menus">
    	<ul><b><i>
    		<xsl:for-each select="menu">
        		<li>
                  <xsl:value-of select="title" />
                  <br></br>
                  <xsl:value-of select="price" />
                   <br></br>
                  <xsl:value-of select="score" />
                  <p></p>
    		   </li>
    		</xsl:for-each>
    	</i></b></ul>
	</xsl:template>
  
</xsl:stylesheet>
