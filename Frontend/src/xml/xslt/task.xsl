<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/">
    	<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
    		<fo:layout-master-set>
    			<fo:simple-page-master master-name="A4-portrait"
    								   page-height="29.7cm"
    								   page-width="21.0cm"
    								   margin="1cm">
    				
    				<fo:region-body/>
                    <fo:region-before/>
                    <fo:region-after extent="1cm" overflow="hidden" />
                
    			</fo:simple-page-master>
    		</fo:layout-master-set>

    		<fo:page-sequence master-reference="A4-portrait"
    						  initial-page-number="1">

                <!-- Page number -->
                <fo:static-content flow-name="xsl-region-after">
                    <fo:block font-size="12.0pt" font-family="sans-serif"
                        padding-after="2.0pt" space-before="2.0pt" text-align="center">
                        <fo:page-number />
                    </fo:block>
                </fo:static-content>

                <!-- body template -->
                 <fo:flow flow-name="xsl-region-body">
                    <xsl:apply-templates select="data" />
                </fo:flow>
    		</fo:page-sequence>

    	</fo:root>
    </xsl:template>

    <xsl:template match="data">

		<!-- Task Title -->
		<fo:block font-size="20.0pt" font-family="serif" font-weight="bold"
		          padding-after="10.0pt" text-align="center"
		          border-bottom-style="solid" border-bottom-color="#4c4cff" border-bottom-width="1.0pt">    
		    <xsl:value-of select="task-name" />
		    <!--<xsl:text>Task</xsl:text>-->
        </fo:block>
        
        <!-- Adjacent Tables for Execution progress detail and input parameters -->
        <fo:table table-layout="fixed" width="100%" border-bottom-width="1.3pt" border-bottom-style="solid" border-bottom-color="#4c4cff" border-collapse="collapse">
        	<fo:table-column column-number="1" column-width="50%"/>
            <fo:table-column column-number="2" column-width="50%"/>
            
            <fo:table-body>
                <fo:table-row>
        			<fo:table-cell>

                        <!-- Table for Execution Progress Detail -->
        				<fo:block padding-before="10.0pt" font-size="14pt" font-family="sans-serif" border-width="1.0pt" border-color="#4c4cff">
        					<fo:block font-weight="bold">&#160;&#160;Execution Progress Details</fo:block>
        					<fo:block padding-before="15.0pt" font-size="10pt" font-family="sans-serif" padding-start="15.0pt">
        						<fo:table table-layout="fixed" width="100%">
                                	<fo:table-column column-number="1" column-width="50%"/>
        					    	<fo:table-column column-number="2" column-width="50%"/>	
        							<fo:table-body>

        							<!-- Current Input Size -->
                                                                <xsl:if test="input-size">
        							<fo:table-row>
        								<fo:table-cell padding-start="20.0pt"><fo:block>Current Input Size:</fo:block></fo:table-cell>
        								<fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="input-size"/></fo:block></fo:table-cell>
        							</fo:table-row>
                                                                </xsl:if>

        							<!-- Scheduled Tasks -->
                                                                <xsl:if test="scheduled-tasks">
        							<fo:table-row>
        								<fo:table-cell padding-start="20.0pt"><fo:block>Scheduled Tasks:</fo:block></fo:table-cell>
        								<fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="scheduled-tasks"/></fo:block></fo:table-cell>
        							</fo:table-row>
                                                                </xsl:if>

        							<!-- Completed tasks -->
                                                                <xsl:if test="completed-tasks">
        							<fo:table-row>
        								<fo:table-cell padding-start="20.0pt"><fo:block>Completed Tasks:</fo:block></fo:table-cell>
        								<fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="completed-tasks"/></fo:block></fo:table-cell>
        							</fo:table-row>
                                                                </xsl:if>

        							<!-- QuickSort: Print if max-recursion-depth attribute exists -->
                                                                <xsl:if test="max-recursion-depth">
        							<fo:table-row>
        										<fo:table-cell padding-start="20.0pt"><fo:block>Max. Recursion Depth:</fo:block></fo:table-cell>
        										<fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="max-recursion-depth"/></fo:block></fo:table-cell>
        							</fo:table-row>
                                                                </xsl:if>
                                                                
                                                                
                                                                
                                                                <!-- Memory footprint -->
                                                                <xsl:if test="memory-footprint">
        							<fo:table-row>
        								<fo:table-cell padding-start="20.0pt"><fo:block>Memory Footprint:</fo:block></fo:table-cell>
        								<fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="memory-footprint"/></fo:block></fo:table-cell>
        							</fo:table-row>
                                                                </xsl:if>
                                                                
                                                                
                                                                <!-- Node Level -->
                                                                <xsl:if test="node-level">
                                                                <fo:table-row>
                                                                    <fo:table-cell padding-start="20.0pt"><fo:block>Node Level:</fo:block></fo:table-cell>
                                                                    <fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="node-level"/></fo:block></fo:table-cell>
                                                                </fo:table-row>
                                                                </xsl:if>
                                    
                                                                <!-- Insert Time -->        
                                                                <xsl:if test="insert-time">
                                                                <fo:table-row>
                                                                    <fo:table-cell padding-start="20.0pt"><fo:block>Insert Time:</fo:block></fo:table-cell>
                                                                    <fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="insert-time"/></fo:block></fo:table-cell>
                                                                </fo:table-row>
                                                                </xsl:if>
                                    
                                                                <!-- Delete Time -->
                                                                <xsl:if test="delete-time">
                                                                <fo:table-row>
                                                                    <fo:table-cell padding-start="20.0pt"><fo:block>Delete Time:</fo:block></fo:table-cell>
                                                                    <fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="delete-time"/></fo:block></fo:table-cell>
                                                                </fo:table-row>     
                                                                </xsl:if>
                                    
                                                                <!-- Search Time -->
                                                                <xsl:if test="search-time">
                                                                <fo:table-row>
                                                                    <fo:table-cell padding-start="20.0pt"><fo:block>Search Time:</fo:block></fo:table-cell>
                                                                    <fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="search-time"/></fo:block></fo:table-cell>
                                                                </fo:table-row>
                                                                </xsl:if>
                                                                 
                                    <!-- Graph Is Directed -->
                                    <xsl:if test="graph-is-directed">
                                    <fo:table-row>
                                        <fo:table-cell padding-start="20.0pt"><fo:block>Graph is directed:</fo:block></fo:table-cell>
                                        <fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="graph-is-directed"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>
                                    
                                    <!-- Graph Is Delayed -->
                                    <xsl:if test="graph-is-delayed">
                                    <fo:table-row>
                                        <fo:table-cell padding-start="20.0pt"><fo:block>Graph is delayed</fo:block></fo:table-cell>
                                        <fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="graph-is-delayed"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>
        							
                                    <!-- empty line -->
        							<fo:table-row><fo:table-cell><fo:block><fo:leader /></fo:block></fo:table-cell></fo:table-row>

        							</fo:table-body>
        						</fo:table>
        					</fo:block>
        				</fo:block>
                    </fo:table-cell>
                    <fo:table-cell>
                        <!-- Table for Input Parameters -->
                        <fo:block padding-before="10.0pt" font-size="14pt"  font-family="sans-serif" border-left-style="solid" border-width="1.0pt" border-color="#4c4cff">
                            <fo:block font-weight="bold">&#160;&#160;Input Parameters</fo:block>
                            <fo:block padding-before="15.0pt" font-size="10pt" font-family="sans-serif">
                            	<fo:table table-layout="fixed" width="100%">
                                	<fo:table-column column-number="1" column-width="50%"/>
                                	<fo:table-column column-number="2" column-width="50%"/> 

                                	<fo:table-body>

                                    <!-- Initial Size -->
                                    <xsl:if test="initial-size">
                                    <fo:table-row>
                                        <fo:table-cell padding-start="20.0pt"><fo:block>Initial Size:</fo:block></fo:table-cell>
                                        <fo:table-cell padding-start="20.0pt" ><fo:block><xsl:value-of select="initial-size"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>

                                    <!-- Final Size -->
                                    <xsl:if test="final-size">                                    
                                    <fo:table-row>
                                        <fo:table-cell padding-start="20.0pt"><fo:block>Final Size:</fo:block></fo:table-cell>
                                        <fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="final-size"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>

                                    <!-- Step Size -->
                                    <xsl:if test="step-size">
                                    <fo:table-row>
                                        <fo:table-cell padding-start="20.0pt"><fo:block>Step Size:</fo:block></fo:table-cell>
                                        <fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="step-size"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>
                                    
                                    <!-- Internal Representation -->
                                    <xsl:if test="internal-representation">
                                    <fo:table-row>
                                        <fo:table-cell padding-start="20.0pt"><fo:block>Internal representation:</fo:block></fo:table-cell>
                                        <fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="internal-representation"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>

                                    <!-- Input Range -->
                                    <xsl:if test="input-range">
                                    <fo:table-row>
                                        <fo:table-cell padding-start="20.0pt"><fo:block>Input Range:</fo:block></fo:table-cell>
                                        <fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="input-range"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>

                                    <!-- Input Distribution -->
                                    <xsl:if test="input-distribution">
                                    <fo:table-row>
                                        <fo:table-cell padding-start="20.0pt"><fo:block>Input Distribution:</fo:block></fo:table-cell>
                                        <fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="input-distribution"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>

                                    <!-- QuickSort: Print if pivot-position exists -->
                                    <xsl:if test="pivot-position">
                                    <fo:table-row>
                                        		<fo:table-cell padding-start="20.0pt"><fo:block>Pivot Position:</fo:block></fo:table-cell>
                                        		<fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="pivot-position"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>
                                    
                                    <!-- Data Element -->
                                    <xsl:if test="data-element">
                                    <fo:table-row>
                                        <fo:table-cell padding-start="20.0pt"><fo:block>Data Element:</fo:block></fo:table-cell>
                                        <fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="data-element"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>
                                    
                                    
                                    
                                    <!-- Graph Fixed Edges -->
                                    <xsl:if test="graph-fixed-edges">
                                    <fo:table-row>
                                        <fo:table-cell padding-start="20.0pt"><fo:block>Fixed Edges:</fo:block></fo:table-cell>
                                        <fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="graph-fixed-edges"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>
                                    
                                    
                                    
                                    <!-- Graph Fixed Size -->
                                    <xsl:if test="graph-fixed-size">
                                    <fo:table-row>
                                        <fo:table-cell padding-start="20.0pt"><fo:block>Fixed Size:</fo:block></fo:table-cell>
                                        <fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="graph-fixed-size"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>
                                    
                                    <!-- Graph Allow self loops -->
                                    <xsl:if test="graph-allow-self-loop">
                                    <fo:table-row>
                                        <fo:table-cell padding-start="20.0pt"><fo:block>Allow self loops:</fo:block></fo:table-cell>
                                        <fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="graph-allow-self-loop"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>
                                    
                                    <!-- Tree Type -->
                                    <xsl:if test="tree-type">
                                    <fo:table-row>
        				<fo:table-cell padding-start="20.0pt"><fo:block>Tree type:</fo:block></fo:table-cell>
        				<fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="tree-type"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>
                                                                
                                    <!-- Tree Range -->
                                    <xsl:if test="tree-range">
                                    <fo:table-row>
                                        <fo:table-cell padding-start="20.0pt"><fo:block>Tree range:</fo:block></fo:table-cell>
        				<fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="tree-range"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>
                                                                
                                    <!-- Number of nodes -->
                                    <xsl:if test="num-nodes">
                                    <fo:table-row>
        				<fo:table-cell padding-start="20.0pt"><fo:block>Number of nodes:</fo:block></fo:table-cell>
        				<fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="num-nodes"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>
                                                                
                                    <!-- Tree Hight -->
                                    <xsl:if test="tree-type">
                                    <fo:table-row>
        				<fo:table-cell padding-start="20.0pt"><fo:block>Tree hight:</fo:block></fo:table-cell>
        				<fo:table-cell padding-start="20.0pt"><fo:block><xsl:value-of select="tree-hight"/></fo:block></fo:table-cell>
                                    </fo:table-row>
                                    </xsl:if>
                                   
                                    <!-- empty line -->
        							<fo:table-row><fo:table-cell><fo:block><fo:leader /></fo:block></fo:table-cell></fo:table-row>

                                	</fo:table-body>
                                
                            	</fo:table>
                            </fo:block>
                        </fo:block>
        			</fo:table-cell>
        		</fo:table-row>
        	</fo:table-body>
        </fo:table>

        <!-- Runtime image -->
        <fo:block font-size="14.0pt" font-weight="bold" padding-before="10.0pt">&#160;&#160;Time Complexity Chart</fo:block>
        <fo:block><fo:leader /></fo:block> <!-- empty line -->
        <!-- image -->
        <fo:block border-bottom-width="1.3pt" border-bottom-style="solid" border-bottom-color="#4c4cff">
        	<fo:external-graphic src="images/image.jpg" content-height="145mm" content-width="180mm" display-align="center" text-align="center" border="solid 0.1pt"/>
        </fo:block>

        <!-- Notes, if any -->
        <fo:block font-size="14.0pt" font-weight="bold" padding-before="10.0pt">&#160;&#160;Notes</fo:block>
        <fo:block><fo:leader /></fo:block> <!-- empty line -->
       <!-- <fo:block>&#160;&#160;&#160;&#160; <xsl:value-of select="notes"/></fo:block> -->
    </xsl:template>
</xsl:stylesheet>