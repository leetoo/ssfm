/**
  * Copyright 2017, Alexander Ray (dev@alexray.me)
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  */

package chat.directives

import com.greencatsoft.angularjs._
import com.greencatsoft.angularjs.core.Compile
import org.scalajs.dom.Element
import org.scalajs.dom.html.Html

@injectable("dialogsList")
class DialogsListDirective($compile: Compile) extends ElementDirective with TemplatedDirective with IsolatedScope {

  override val templateUrl: String = "dialogs-template.html"
  replace = true

  bindings ++= Seq(
    "dialogs" := "dialogs"
  )

  override def link(scope: ScopeType, elems: Seq[Element], attrs: Attributes) {
    super.link(scope, elems, attrs)

    val template = getTemplateUrl(elems.map(AngularElement(_)), attrs)
    elems.headOption.map(_.asInstanceOf[Html]).map { elem =>
      elem.innerHTML = template
      $compile(elem)
    }

  }

}